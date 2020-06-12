package utils;

import java.util.Formatter;

public class NumFormat {

    public static String code6(Integer num){
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%06d",num);
        return stringBuilder.toString();
    }
    public static String code4(Integer num){
        StringBuilder stringBuilder = new StringBuilder();
        Formatter formatter = new Formatter(stringBuilder);
        formatter.format("%04d",num);
        return stringBuilder.toString();
    }
}
