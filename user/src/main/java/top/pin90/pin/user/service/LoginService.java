package top.pin90.pin.user.service;

import entity.Result;

import javax.servlet.http.HttpServletRequest;

public interface LoginService {
    public Result login(String username, String password);
    public Result logout(HttpServletRequest request);
}
