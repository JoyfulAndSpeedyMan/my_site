package top.pin90.pin.freevideo.controller;

import ch.qos.logback.core.AppenderBase;
import entity.Result;
import entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@Slf4j
@RestControllerAdvice
public class BaseExceptionHandler {
    //处理验证异常
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result MethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.debug("MethodArgumentNotValidException");
        return Result.build(StatusCode.ARGUMENTERROR,e.getMessage());
    }
    //处理验证异常
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public Result MissingServletRequestParameterException(MissingServletRequestParameterException e){
        log.debug("MissingServletRequestParameterException");
        return Result.build(StatusCode.ARGUMENTERROR,e.getMessage());
    }
    //处理验证异常
    @ExceptionHandler(value = BindException.class)
    public Result BindException(BindException e){
        log.debug("BindException");
        return Result.build(StatusCode.ARGUMENTERROR,e.getMessage());
    }
    @ExceptionHandler(value = Exception.class)
    public Result Exception(Exception e){
        //处理验证异常
        if(e instanceof ConstraintViolationException) {
            log.debug("ConstraintViolationException");
            return Result.build(StatusCode.ARGUMENTERROR, e.getMessage());
        }
        e.printStackTrace();
        return Result.build(StatusCode.SERVERERROR);
    }
}
