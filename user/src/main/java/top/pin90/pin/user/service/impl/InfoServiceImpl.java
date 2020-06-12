package top.pin90.pin.user.service.impl;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import top.pin90.pin.user.dao.UserDao;
import top.pin90.pin.user.pojo.User;
import top.pin90.pin.user.service.InfoService;
import utils.JwtUtil;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Service
public class InfoServiceImpl implements InfoService {

    @Autowired
    private UserDao userDao;

    @Override
    public Result getBaseInfo(String token) {
        Long userId;
        try{
            userId=JwtUtil.getUserId(token);
        }
        catch (Exception e){
            return Result.build(StatusCode.ACCESSERROR,"用户身份过期");
        }
        Map<String, String> userBaseInfo = userDao.getUserBaseInfo(userId);
        return Result.ok("获取成功",userBaseInfo);
    }
//    @NotNull(message = "你还未登陆")
    @Override
    public Result getDetailInfo(String token) {
        Long userId;
        try{
            userId=JwtUtil.getUserId(token);
        }
        catch (Exception e){
            return Result.build(StatusCode.ACCESSERROR,"用户身份过期");
        }
        Map<String, Object> map = userDao.get(userId);

        return Result.ok("获取成功",map);
    }
}
