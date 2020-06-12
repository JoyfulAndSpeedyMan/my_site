package top.pin90.pin.freevideo.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "website_kind")
public class WebsiteKind {
    @Id
    private Long id;
    private String kindName;
    private String createTime;
}
