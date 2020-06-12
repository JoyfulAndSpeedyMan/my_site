

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.pin90.pin.spit.SpitApplication;
import top.pin90.pin.spit.dao.SpitDao;
import top.pin90.pin.spit.pojo.Spit;
import utils.IdWorker;

import java.util.Arrays;
import java.util.Date;

@SpringBootTest(classes = {SpitApplication.class})
public class TestSpitDao {

    @Autowired
    private SpitDao spitDao;
    @Autowired
    private IdWorker idWorker;

    @Test
    public void findAll() {
        System.out.println(JSON.toJSONString(spitDao.findAll()));
    }
    @Test
    public void insert() {
        Spit spit=new Spit();
        spit.setId(idWorker.nextId());
        spit.setUserId(1264556125311787008L);
//        spit.setNickname("灰太狼");
        spit.setTitle("这是一个标题");
        spit.setContent("这里是吐槽内容，这里是吐槽内容，这里是吐槽内容，这里是吐槽内容这里是吐槽内容这里是吐槽内容这里是吐槽内容这里是吐槽内容这里是吐槽内容这里是吐槽内容这里是吐槽内容");
        spit.setThumbs(3);
        spit.setCommentNum(4);
        String []s=new String[]{"视频网站","不好用","太卡"};
        spit.setTag(Arrays.asList(s));
        spit.setCreateTime(new Date());
        System.out.println(spitDao.save(spit));
    }


    @Test
    public  void remove(){
     spitDao.deleteAll();
    }
}
