package top.pin90.pin.user.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    Long id;//逻辑主键
    String username;//登陆使用的用户名
    String nickname;//别名
    String avatar; //用户头像
    String password;//密码
    String roles;   //用户角色
    String email;//邮箱
    String phone;//电话号码
    Integer msgUnreadNum;
    String privileges;//用户特权
    Integer status;//用户状态
    Date avaidate;//账号可用日期
    Date create_time;//账号创建时间
    Date update_time;//账号信息更新时间
}
