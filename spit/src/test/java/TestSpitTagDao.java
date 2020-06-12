

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.pin90.pin.spit.SpitApplication;
import top.pin90.pin.spit.dao.SpitTagDao;
import top.pin90.pin.spit.pojo.SpitTag;
import utils.IdWorker;

import java.util.Date;

@SpringBootTest(classes = {SpitApplication.class})
public class TestSpitTagDao {

    @Autowired
    SpitTagDao spitTagDao;
    @Autowired
    IdWorker idWorker;

    @Test
    public void findAll() {
        System.out.println(spitTagDao.findAll());
    }
    @Test
    public void insert() {
        SpitTag spitTag=new SpitTag();
        spitTag.setId(idWorker.nextId());
        spitTag.setTagName("视频网站");
        spitTag.setCreateTime(new Date());
        spitTag.setUse(10);
        System.out.println(spitTagDao.save(spitTag));
    }
    @Test
    public  void remove(){
     spitTagDao.deleteAll();
    }
}
