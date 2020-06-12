package top.pin90.pin.freevideo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.pin90.pin.freevideo.pojo.UserThumb;

public interface UserThumbDao extends JpaRepository<UserThumb,Long>, JpaSpecificationExecutor<UserThumb> {
    public UserThumb findByUserIdAndWebsiteId(Long userId,Long websiteId);
}
