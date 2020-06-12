package top.pin90.pin.freevideo.service.impl;

import entity.Page;
import entity.Result;
import entity.StatusCode;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import top.pin90.pin.freevideo.dao.UserThumbDao;
import top.pin90.pin.freevideo.dao.WebsiteDao;
import top.pin90.pin.freevideo.dao.WebsiteKindDao;
import top.pin90.pin.freevideo.pojo.UserThumb;
import top.pin90.pin.freevideo.pojo.Website;
import top.pin90.pin.freevideo.pojo.WebsiteKind;
import top.pin90.pin.freevideo.service.WebsiteService;
import utils.IdWorker;
import utils.JwtUtil;

import javax.persistence.criteria.*;
import java.util.*;

@Service
@Transactional
public class WebsiteServiceImpl implements WebsiteService {
    @Autowired
    private WebsiteDao websiteDao;

    @Autowired
    private UserThumbDao userThumbDao;

    @Autowired
    private WebsiteKindDao websiteKindDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public Page getList(String token,int page, int size) {
        if(token==null){
            long total = websiteDao.count();
            List<Map<String,Object>> list = websiteDao.getList((page-1)*size, size);
            return Page.build(total,page,list.size(),list);
        }
        else {
            Long userId = JwtUtil.getUserId(token);
            long total = websiteDao.count();
            List<Map<String,Object>> list = websiteDao.getHasThumbList(userId,(page-1)*size,size);
            return Page.build(total,page,list.size(),list);
        }
    }


    @Override
    public Result videoThumb(String token, Long id) {
        Long userId;
        try{
            userId=JwtUtil.getUserId(token);
        }
        catch (Exception e){
            return Result.build(StatusCode.ACCESSERROR,"用户身份过期");
        }
        Website one = websiteDao.getOne(id);
        one.setThumbs(one.getThumbs()+1);
        websiteDao.save(one);

        UserThumb userThumb = new UserThumb();
        userThumb.setId(idWorker.nextId());
        userThumb.setUserId(userId);
        userThumb.setWebsiteId(id);
        userThumb.setCreateTime(new Date());
        userThumbDao.save(userThumb);
        return Result.ok("点赞成功");
    }

    @Override
    public Result videoUnthumb(String token, Long id) {
        Long userId;
        try{
            userId=JwtUtil.getUserId(token);
        }
        catch (Exception e){
            return Result.build(StatusCode.ACCESSERROR,"用户身份过期");
        }
        UserThumb userThumb = userThumbDao.findByUserIdAndWebsiteId(userId, id);
        if(userThumb!=null){
            Website website = websiteDao.findById(userThumb.getWebsiteId()).get();
            if(website!=null) {
                website.setThumbs(website.getThumbs()-1);
                websiteDao.save(website);
                userThumbDao.delete(userThumb);
                return Result.ok("取消成功");
            }
        }
        return Result.ok("你还未点赞");
    }

    @Override
    public Page getKind() {
        List<WebsiteKind> list = websiteKindDao.findAll();
        Page build = Page.build((long)list.size(), 1, list.size(), list);
        return build;
    }
}
