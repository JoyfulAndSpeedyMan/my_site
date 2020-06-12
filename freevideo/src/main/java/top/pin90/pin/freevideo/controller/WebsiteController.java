package top.pin90.pin.freevideo.controller;

import entity.Page;
import entity.Result;
import entity.StatusCode;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.validator.constraints.Range;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pin90.pin.freevideo.pojo.Website;
import top.pin90.pin.freevideo.service.WebsiteService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@RestController
@Validated
public class WebsiteController {

    @Autowired
    private WebsiteService websiteService;
    @Autowired
    private HttpServletRequest request;
    @GetMapping("/list/{page}/{size}")
    public Result getList(@PathVariable @Valid @Min(value = 1,message = "错误的页码") @NotNull(message = "页码") Integer page,
                          @PathVariable @Valid @Range(min = 1,max = 50) Integer size) {

        String token = request.getHeader("X-User-Token");
        Page pages = websiteService.getList(token,page, size);
        return Result.ok("ok", pages);
    }

    @PutMapping("/thumb")
    public Result videoThumb(@Valid @NotNull Long id) {
        String token = request.getHeader("X-User-Token");
        if (StringUtils.isBlank(token))
            return Result.build(StatusCode.ARGUMENTERROR, "未登录");

        Result result;
        try {
            result = websiteService.videoThumb(token, id);
        } catch (DataIntegrityViolationException e) {
            result = Result.build(StatusCode.REPERROR, "你已经点过赞了");
        }
        return result;
    }
    @PutMapping("/unthumb")
    public Result videoUnthumb(@Valid @NotNull Long id) {
        String token = request.getHeader("X-User-Token");
        if (StringUtils.isBlank(token))
            return Result.build(StatusCode.ARGUMENTERROR, "未登录");

        Result result =websiteService.videoUnthumb(token,id);

        return result;
    }
    @GetMapping("/kind")
    public Result getKind(){
        Page kinds = websiteService.getKind();
        return Result.build(StatusCode.OK,"获取成功",kinds);
    }

//    @PutMapping("/share")
//    public Result shareWebsite(@NotNull @Size(max = 10)
//                                           String name,
//                               @Pattern(regexp = "^(https?):\\/\\/[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]$")
//                                       String url,
//                               @NotNull @Size(max = 10)
//                                           String kind,
//                               @Size(max = 50)
//                                           String detail){
//
//        Result result = websiteService.shareWebsite(name, url, kind, detail);
//
//        return result;
//    }
    @PutMapping("/share")
    public Result shareWebsite(@Valid Website website){
        System.out.println(website);
        Result result;
        result = websiteService.shareWebsite(website);
        return result;
    }

}