package top.pin90.pin.freevideo.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Entity
@Table(name = "website")
public class Website {
    @Id
    private Long id;
    @NotNull
    @Size(max = 10)
    private String name;
    @Pattern(regexp = "^(https?):\\/\\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$")
    private String url;
    private String image;
    @NotNull @Size(max = 10)
    private String kind;
    @Size(max = 50)
    private String detail;
    private Integer status=StatusWebsite.TOAUDIT;
    private Integer thumbs=0;
    private Integer weight=0;
    private Date createTime;
    private Date updateTime;
}
