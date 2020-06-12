package top.pin90.pin.spit.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class SpitComment {
    @Id
    private Long id;
    private Long spitId;
    private Long replyId;
    private String replyUserNickname;
    private Long userId;
    private String userNickname;
    private String userAvatar;
    private String content;
    private Integer thumbs;
    private Date createTime;
}
