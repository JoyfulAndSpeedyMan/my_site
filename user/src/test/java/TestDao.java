import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.pin90.pin.user.UserApplication;
import top.pin90.pin.user.dao.UserDao;
import top.pin90.pin.user.pojo.User;
import utils.IdWorker;

import java.util.Date;


@SpringBootTest(classes={UserApplication.class})// 指定启动类
public class TestDao {
    @Autowired
    UserDao userDao;
    @Autowired
    IdWorker idWorker;

    @Test
//    @Rollback(false)
    public void testUserInsert(){
        long id=idWorker.nextId();
        User user = new User();
        user.setId(id);
        user.setUsername("905991211");
        user.setPassword("123456");
        user.setNickname("灰太狼");
        user.setEmail("905991211@qq.com");
        user.setPhone("17854570896");
        user.setPrivileges("vip");
        user.setStatus(1);
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        System.out.println(userDao.save(user));

    }
    @Test
    public void testUserFind(){
        System.out.println(userDao.findAll().get(0).toString());
    }
}
