package entity;

import lombok.Data;

import java.util.List;

@Data
public class Page {
    private Long total;
    private Integer page;
    private Integer size;
    private Object items;

    public Page(Long total, Integer page, Integer size, Object items) {
        this.total = total;
        this.page = page;
        this.size = size;
        this.items = items;
    }
    public static Page build(Long total, Integer page, Integer size, Object items){
        return new Page(total,page,size,items);
    }
}
