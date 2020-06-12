package top.pin90.pin.freevideo.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "website")
public class Website {
    @Id
    private Long id;
    private String name;
    private String url;
    private String image;
    private String kind;
    private String detail;
    private Integer status;
    private Integer thumbs;
    private Integer weight;
    private Date create_time;
    private Date update_time;
}
