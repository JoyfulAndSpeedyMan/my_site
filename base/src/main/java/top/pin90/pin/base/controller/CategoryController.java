package top.pin90.pin.base.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.pin90.pin.base.pojo.Category;
import top.pin90.pin.base.service.CategoryService;
import utils.RequestUntils;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private HttpServletRequest request;

    @PutMapping
    public Result addCategory(@RequestBody @Valid Category category){
        String token = RequestUntils.getToken(request);
        Result result = categoryService.save(token, category);
        return result;
    }
    @DeleteMapping
    public Result deleteCategory(@Valid @NotNull Long id){
        String token = RequestUntils.getToken(request);
        Result result = categoryService.delete(token, id);
        return result;
    }
    @GetMapping
    public Result getCategory(){
        Result result = categoryService.findAll();
        return result;
    }
}
