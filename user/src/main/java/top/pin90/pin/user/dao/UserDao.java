package top.pin90.pin.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import top.pin90.pin.user.pojo.User;

import java.util.Map;

public interface UserDao extends JpaRepository<User,Long> , JpaSpecificationExecutor<User> {
    @Query(value = "select * from user where username=(:name) or email=(:name) or phone=(:name)",nativeQuery = true)
    public User get(@Param("name") String name);
    @Query(value = "select avatar, " +
            "       avaidate, " +
            "       roles, " +
            "       create_time, " +
            "       phone, " +
            "       nickname, " +
            "       email, " +
            "       id, " +
            "       username, " +
            "       privileges, " +
            "       msg_unread_num, " +
            "       status " +
            "from user " +
            "where id = ?",nativeQuery = true)
    public Map<String,Object> get(Long userId);
    @Query(value = "select username,nickname,avatar,msg_unread_num urMsgNum from user where id=1264556125311787008",nativeQuery = true)
    public Map<String,String> getUserBaseInfo(Long userId);
}