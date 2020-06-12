package top.pin90.pin.freevideo.controller;

import entity.Result;
import entity.StatusCode;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


@RestControllerAdvice
public class BaseExceptionHandler {

    //处理验证异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidException(MethodArgumentNotValidException e){
        return Result.build(StatusCode.ARGUMENTERROR,e.getMessage());
    }
    //处理验证异常
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Result MissingServletRequestParameterException(MissingServletRequestParameterException e){
        return Result.build(StatusCode.ARGUMENTERROR,e.getMessage());
    }
    @ExceptionHandler(value = Exception.class)
    public Result Exception(Exception e){
        //处理验证异常
        if(e instanceof ConstraintViolationException)
            return Result.build(StatusCode.ARGUMENTERROR,e.getMessage());
        e.printStackTrace();
        return Result.build(StatusCode.ERROR);
    }
}
