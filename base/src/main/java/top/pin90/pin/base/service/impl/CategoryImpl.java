package top.pin90.pin.base.service.impl;

import entity.Page;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.pin90.pin.base.dao.CategoryDao;
import top.pin90.pin.base.pojo.Category;
import top.pin90.pin.base.service.CategoryService;
import utils.IdWorker;
import utils.JwtUtil;

import java.util.List;
@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public Result findAll() {
        List<Category> all = categoryDao.findAll();
        long total=(long)all.size();
        Page page = Page.build(total, 1, all.size(), all);
        return Result.ok("获取成功",page);
    }

    @Override
    public Result save(String token, Category category) {
        boolean admin = JwtUtil.isAdmin(token);
        if(admin){
            category.setId(idWorker.nextId());
            categoryDao.save(category);
            return Result.ok("添加成功");
        }else {
            return Result.build(StatusCode.ACCESSERROR,"权限不足");
        }

    }

    @Override
    public Result delete(String token, Long id) {
        boolean admin = JwtUtil.isAdmin(token);
        if(admin){
            categoryDao.deleteById(id);
            return Result.ok("删除成功");
        }else {
            return Result.build(StatusCode.ACCESSERROR,"权限不足");
        }
    }

}
