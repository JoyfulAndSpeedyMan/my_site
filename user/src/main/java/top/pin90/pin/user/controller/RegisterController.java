package top.pin90.pin.user.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.pin90.pin.user.service.RegisterService;
import top.pin90.pin.user.vo.RegisterUser;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/register")
@Validated
@CrossOrigin("*")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @PostMapping
    public Result register( @NotNull(message = "手机号不能为空")
                            @Pattern(regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$", message = "手机号格式错误")
                                        String phone,
                            @NotNull(message = "密码不能为空")
                                        String password,
                            @NotNull(message = "验证码不能为空")
                            @Size(max = 6,min = 6,message = "验证码格式错误")
                            String code) {
        Result result = registerService.register(phone, password, code);
        return result;
    }


    @PostMapping("/code")
    public Result sendCode(@NotNull(message = "手机号码为空")
                           @Pattern(regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$", message = "手机号格式错误")
                           String phone) {

        Result result;
        try {
            result = registerService.sendCode(phone);
        }
        catch (DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("你已经注册过了");
        }
        return result;
    }

}
