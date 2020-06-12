package top.pin90.pin.spit.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Data
public class Spit {
    @Id
    private Long id;
    private Long userId;
    private String userNickname;
    private String userAvatar;
    private String title;
    private String content;
    private Integer thumbs;
    private Integer commentNum;
    private List<String> tag;
    private Date createTime;
}

