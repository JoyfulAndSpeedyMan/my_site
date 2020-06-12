package entity;

import lombok.Data;

@Data
public class Result {
    int code;
    String message;
    Object data;

    public Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result ok(){
        return Result.build(StatusCode.OK,null,null);
    }

    public static Result ok(String message){
        return Result.build(StatusCode.OK,message,null);
    }
    public static Result ok(String message,Object data){
        return Result.build(StatusCode.OK,message,data);
    }

    public static Result build(Integer code){
        return Result.build(code,null,null);
    }
    public static Result build(Integer code,String message){
        return Result.build(code,message,null);
    }
    public static Result build(Integer code,String message,Object data){
        return new Result(code,message,data);
    }

}
