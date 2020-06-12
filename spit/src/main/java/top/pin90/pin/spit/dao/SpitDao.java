package top.pin90.pin.spit.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import top.pin90.pin.spit.pojo.Spit;

public interface SpitDao extends MongoRepository<Spit,Long> {
}
