import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import top.pin90.pin.user.UserApplication;

import java.util.concurrent.TimeUnit;

@SpringBootTest(classes = UserApplication.class)
public class TestRedis {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Test
    public void test(){
        redisTemplate.opsForValue().set("test","100",30L, TimeUnit.SECONDS);
    }
}
