package top.pin90.pin.spit.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class SpitTag {
    @Id
    private Long id;
    private String tagName;
    private Date createTime;
    private Integer use;
}
