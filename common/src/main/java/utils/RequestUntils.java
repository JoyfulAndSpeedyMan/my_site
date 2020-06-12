package utils;

import javax.servlet.http.HttpServletRequest;

public class RequestUntils {
    static private final String tokenKey="X-User-Token";
    static public String getToken(HttpServletRequest request){
        return request.getHeader(tokenKey);
    }
}
