package top.pin90.pin.user.service;

import entity.Result;

public interface RegisterService {
    public Result register(String phone, String password, String code);
    public Result sendCode(String phone);
}
