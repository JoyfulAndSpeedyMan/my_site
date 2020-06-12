package top.pin90.pin.freevideo.service;

import entity.Page;
import entity.Result;
import top.pin90.pin.freevideo.pojo.Website;


public interface WebsiteService {
    Page getList(String token,int page, int size);
    Result videoThumb(String token,Long id);
    Result videoUnthumb(String token,Long id);
    Page getKind();
    Result shareWebsite(Website websiteParam);
}
