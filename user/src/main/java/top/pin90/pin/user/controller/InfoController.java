package top.pin90.pin.user.controller;

import entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.pin90.pin.user.service.InfoService;
import utils.RequestUntils;

import javax.servlet.http.HttpServletRequest;

@RestController
public class InfoController {
    @Autowired
    private InfoService infoService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping("/baseInfo")
    public Result getBaseInfo(){
        String token = RequestUntils.getToken(request);
        Result result = infoService.getBaseInfo(token);
        return result;
    }
    @GetMapping
    public Result getDetailInfo(){
        String token = RequestUntils.getToken(request);
        Result result = infoService.getDetailInfo(token);
        return result;
    }
}
