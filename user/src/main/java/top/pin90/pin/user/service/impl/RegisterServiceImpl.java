package top.pin90.pin.user.service.impl;


import entity.Result;
import entity.StatusCode;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import top.pin90.pin.user.dao.UserDao;
import top.pin90.pin.user.pojo.User;
import top.pin90.pin.user.service.RegisterService;
import utils.NumFormat;
import utils.IdWorker;
import utils.SmsUtils;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@RefreshScope
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${sms.isSend}")
    private boolean isSend;

    @Override
    public Result register(String phone, String password, String code) {
        long id = idWorker.nextId();
        String redisKey="register:" + phone;
        String code6= redisTemplate.opsForValue().get(redisKey);
        if(code.equals(code6)){
            User user = new User();

            user.setPhone(phone);
            user.setPassword(password);

            user.setId(id);
            user.setStatus(1);
            user.setMsgUnreadNum(0);
            user.setRoles("user");
            user.setCreate_time(new Date());
            user.setUpdate_time(new Date());
            System.out.println(userDao.save(user));
            redisTemplate.delete(redisKey);
            return Result.ok("注册成功");
        }
        else {
            return Result.build(StatusCode.ERROR,"验证码错误");
        }
    }

    @Override
    public Result sendCode(String phone) {
        String code6;
        code6 = redisTemplate.opsForValue().get("register:" + phone);
        if (StringUtils.isBlank(code6)) {
            code6 = NumFormat.code6(RandomUtils.nextInt(0, 1000000));
            redisTemplate.opsForValue().set("register:" + phone, code6, 60, TimeUnit.SECONDS);
            sendCodeMsg(phone,code6);
            return Result.ok("发送成功");
        } else {
            return Result.build(StatusCode.REPERROR, "您操作的太过频繁了");
        }
    }

    public void sendCodeMsg(String phone,String code) {
        System.out.println("sendSmsRegisterCode：" + code);
        System.out.println("isSend: "+isSend);
        if(isSend){
            SmsUtils.sendCode(phone, code);
        }

    }
}
