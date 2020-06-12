package entity;

public class StatusCode {
    public static final int OK=15000;//成功
    public static final int ERROR =15001;//失败
    public static final int LOGINERROR =15002;//用户名或密码错误
    public static final int ACCESSERROR =15003;//权限不足
    public static final int REMOTEERROR =15004;//远程调用失败
    public static final int REPERROR =15005;//重复操作
    public static final int ARGUMENTERROR =15006;//参数错误
}
