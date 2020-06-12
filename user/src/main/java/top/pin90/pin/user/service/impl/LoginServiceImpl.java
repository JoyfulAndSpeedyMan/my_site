package top.pin90.pin.user.service.impl;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.pin90.pin.user.dao.UserDao;
import top.pin90.pin.user.pojo.User;
import top.pin90.pin.user.service.LoginService;
import utils.IdWorker;
import utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private IdWorker idWorker;

    @Override
    public Result login(String username, String password) {
        User user = userDao.get(username);
        if(user==null)
            return Result.build(StatusCode.ERROR,"用户不存在");
        if(user.getPassword().equals(password)){
            String token = JwtUtil.creatToken(idWorker.nextId(), user.getId(), user.getRoles());
            Map<String,String> tokenMap = new LinkedHashMap<>();
            tokenMap.put("token", token);
            return Result.ok("登录成功", tokenMap);
        }
        else {
            return Result.build(StatusCode.ACCESSERROR,"密码错误");
        }
    }

    @Override
    public Result logout(HttpServletRequest request) {
        return null;
    }
}
