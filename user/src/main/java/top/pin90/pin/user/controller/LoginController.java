package top.pin90.pin.user.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.pin90.pin.user.service.LoginService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@Validated
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public Result login(@Valid @NotNull String username,@Valid @NotNull String password){
        Result result = loginService.login(username, password);
        return result;
    }
    @PostMapping("/logout")
    public Result logout(){
        return Result.ok("退出成功");
    }
}
