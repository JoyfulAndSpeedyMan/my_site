package utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    static private String key="songxiangxi";
    static private Long ttl=2592000000L;


    /**
     *
     * @param id    token id
     * @param userId 登录使用的用户名
     * @param roles 用户角色
     *
     * @return
     */
    static  public String creatTokenNoTTL(Long id, Long userId, String roles){
        return creatToken(id,userId,roles,null);
    }
    static public String creatToken(Long id, Long userId, String roles){
        return creatToken(id,userId,roles,ttl);
    }

    /**
     *
     * @param id    token id
     * @param userId 用户Id
     * @param roles 用户角色
     * @param ttl   token过期时间
     * @return
     */
    static public String creatToken(Long id, Long userId, String roles, Long ttl){
        JwtBuilder builder = Jwts.builder()
                .setId(id.toString())
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,key)
                .claim("roles",roles);
        if(ttl!=null)
            builder.setExpiration(new Date(System.currentTimeMillis()+ttl));
        return builder.compact();
    }

    static public Claims parseToken(String token){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
    }
    static public Long getUserId(String token){
        Claims claims = JwtUtil.parseToken(token);
        String  sub = (String)claims.get("sub");
        return Long.parseLong(sub);
    }
    static public boolean isAdmin(String token){
        try {
            Claims claims = JwtUtil.parseToken(token);
            String roles = (String) claims.get("roles");
            if(roles==null || !roles.equals("Admin"))
                return false;
            return true;
        }
        catch (Exception e){
            return false;
        }

    }
    static public String getKey() {
        return key;
    }

    static public void setKey(String key) {
        JwtUtil.key = key;
    }

    static public Long getTtl() {
        return ttl;
    }

    static public void setTtl(Long ttl) {
        JwtUtil.ttl = ttl;
    }
}
