import io.jsonwebtoken.Claims;
import org.junit.Before;
import org.junit.Test;
import utils.IdWorker;
import utils.JwtUtil;

import java.util.Arrays;

public class TestJwt {

//    IdWorker idWorker;
//    @Before
//    public void init(){
////        jwtUtil=new JwtUtil("songxiangxi",200000L);
//        idWorker=new IdWorker();
//    }
//    @Test
//    public void create(){
//        String token=JwtUtil.creatTokenNoTTL(idWorker.nextId(),1L,"Admin");
//        System.out.println(token);
//        System.out.println(token.length());
//        System.out.println(Arrays.toString(token.split("\\.")));
//    }
//    @Test
//    public void parse(){
//        String token="eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMjY0NzMxMzY0NDg2MzczMzc2Iiwic3ViIjoi54Gw5aSq54u8IiwiaWF0IjoxNTkwMzcwNDI5LCJyb2xlcyI6IkFkbWluIiwiYXZhdGFyIjoiL3lzLnBuZyJ9.auCbkZM9uIXAqCq6sC5coLsHpOlV8xie8JV20MRIxcE";
//        Claims claims = JwtUtil.parseToken(token);
//        System.out.println(claims);
//    }
}
