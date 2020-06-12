package top.pin90.pin.freevideo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "user_thumb")
public class UserThumb {
    @Id
    Long id;
    Long userId;
    Long websiteId;
    Date createTime;

}
