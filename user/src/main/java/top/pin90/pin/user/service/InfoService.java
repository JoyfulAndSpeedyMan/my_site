package top.pin90.pin.user.service;

import entity.Result;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;
@Validated
public interface InfoService {
    public Result getBaseInfo(@NotNull(message = "你还未登陆")String token);
    public Result getDetailInfo(@NotNull(message = "你还未登陆")String token);

}
