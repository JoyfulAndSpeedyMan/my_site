package top.pin90.pin.user.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class RegisterUser {

    @NotNull(message = "用户名不能为空")
    private String username;
    @NotNull(message = "密码不能为空")
    private String password;
    @NotNull(message = "手机号不能为空")
    @Pattern(
            regexp = "^[1](([3][0-9])|([4][5-9])|([5][0-3,5-9])|([6][5,6])|([7][0-8])|([8][0-9])|([9][1,8,9]))[0-9]{8}$"
            , message = "手机号格式错误")
    private String phone;
    @NotNull(message = "验证码不能为空")
    @Size(max = 6,min = 6,message = "验证码格式错误")
    private String code;
}
