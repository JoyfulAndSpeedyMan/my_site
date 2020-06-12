package top.pin90.pin.base.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name = "category")
public class Category {
    @Id
    private Long id;
    @NotNull(message = "分类名不能为空")
    private String name;
    private String icon;
    @NotNull(message = "基本描述不能为空")
    private String detail;
    @NotNull(message = "路径不能为空")
    private String path;
}
