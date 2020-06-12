

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import top.pin90.pin.spit.SpitApplication;
import top.pin90.pin.spit.dao.SpitCommentDao;
import top.pin90.pin.spit.pojo.SpitComment;
import utils.IdWorker;
import utils.ListUtil;

import java.util.Date;

@SpringBootTest(classes = {SpitApplication.class})
public class TestSpitCommentDao {

    @Autowired
    SpitCommentDao spitCommentDao;
    @Autowired
    IdWorker idWorker;

    @Test
    public void findAll() {
//        ListUtil.printList(spitCommentDao.findAll());
        System.out.println(JSON.toJSONString(spitCommentDao.findAll()));
    }
    @Test
    public  void remove(){
     spitCommentDao.deleteAll();
    }
    @Test
    public void insertComment(){
//        SpitComment spitComment = new SpitComment();

//        spitComment.setId(idWorker.nextId());
//        spitComment.setSpitId(1265475134534275072L);
//        spitComment.setReplyId(0L);
//        spitComment.setReplyUserNickname(null);
//        spitComment.setUserId(idWorker.nextId());
//        spitComment.setUserNickname("黑太狼");
//        spitComment.setContent("这是第一个吐槽评论");
//        spitComment.setThumbs(0);
//        spitComment.setCreateTime(new Date());

//        spitComment.setId(idWorker.nextId());
//        spitComment.setSpitId(1265475134534275072L);
//        spitComment.setReplyId(1269169722465767424L);
//        spitComment.setReplyUserNickname("黑太狼");
//        spitComment.setUserId(idWorker.nextId());
//        spitComment.setUserNickname("红太狼");
//        spitComment.setContent("这是第二个吐槽评论");
//        spitComment.setThumbs(0);
//        spitComment.setCreateTime(new Date());

//        spitComment.setId(idWorker.nextId());
//        spitComment.setSpitId(1265475134534275072L);
//        spitComment.setReplyId(1269169722465767424L);
//        spitComment.setReplyUserNickname("黑太狼");
//        spitComment.setUserId(idWorker.nextId());
//        spitComment.setUserNickname("小灰灰");
//        spitComment.setContent("这是第三个吐槽评论");
//        spitComment.setThumbs(0);
//        spitComment.setCreateTime(new Date());

//        spitComment.setId(idWorker.nextId());
//        spitComment.setSpitId(1265475134534275072L);
//        spitComment.setReplyId(1269171157182001152L);
//        spitComment.setReplyUserNickname("小灰灰");
//        spitComment.setUserId(idWorker.nextId());
//        spitComment.setUserNickname("喜羊羊");
//        spitComment.setContent("这是第四个吐槽评论");
//        spitComment.setThumbs(0);
//        spitComment.setCreateTime(new Date());
//
//        spitCommentDao.insert(spitComment);
    }
}
