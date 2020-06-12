package top.pin90.pin.freevideo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import top.pin90.pin.freevideo.pojo.UserThumb;
import top.pin90.pin.freevideo.pojo.Website;

import java.util.List;
import java.util.Map;

public interface WebsiteDao extends JpaRepository<Website, Long>, JpaSpecificationExecutor<Website> {
    /**
     * 分页获取视频网站列表（为登录）
     * @param page
     * @param size
     * @return
     */
    @Query(
            value = "select id,  " +
                    "       name,  " +
                    "       url,  " +
                    "       image,  " +
                    "       kind,  " +
                    "       detail,  " +
                    "       status,  " +
                    "       thumbs,  " +
                    "       create_time,  " +
                    "       update_time  " +
                    "from website w  " +
                    "where status = 1  " +
                    "order by w.weight desc,w.thumbs desc  " +
                    "limit ?,?",
            nativeQuery = true)
    List<Map<String, Object>> getList(int page, int size);

    /**
     * 分页获取视频网站列表（已登录）
     * @param userId
     * @param page
     * @param size
     * @return
     */
    @Query(value ="select w.id, " +
            "       any_value(w.name)                                as name, " +
            "       any_value(w.url)                                 as url, " +
            "       any_value(w.image)                               as image, " +
            "       any_value(w.kind)                                as kind, " +
            "       any_value(w.detail)                              as detail, " +
            "       any_value(w.status)                              as status, " +
            "       any_value(w.thumbs)                              as thumbs, " +
            "       bit_or(if(w.id = ut.website_id, true, false)) as isThumb " +
            "from website w " +
            "         left join user_thumb ut on ut.user_id = ? " +
            "where w.status=1 "+
            "group by id " +
            "order by max(w.weight)desc,max(w.thumbs) desc " +
            "limit ?,?;", nativeQuery = true)
    List<Map<String, Object>> getHasThumbList(Long userId, int page, int size);

    List<Website> findByName(String name);

}

