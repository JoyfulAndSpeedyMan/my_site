package top.pin90.pin.spit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.pin90.pin.spit.pojo.SpitTag;

public interface SpitTagDao extends MongoRepository<SpitTag,Long> {
}
