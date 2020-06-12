package top.pin90.pin.base.service;

import entity.Result;
import top.pin90.pin.base.pojo.Category;

public interface CategoryService {
    Result findAll();
    Result save(String token,Category category);
    Result delete(String token,Long id);
}
