package top.pin90.pin.spit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.pin90.pin.spit.pojo.SpitComment;

public interface SpitCommentDao extends MongoRepository<SpitComment,Long> {
}
