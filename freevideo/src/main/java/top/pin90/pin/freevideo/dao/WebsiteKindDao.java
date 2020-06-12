package top.pin90.pin.freevideo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.pin90.pin.freevideo.pojo.WebsiteKind;

public interface WebsiteKindDao extends JpaRepository<WebsiteKind,Long>, JpaSpecificationExecutor<WebsiteKind> {
}
