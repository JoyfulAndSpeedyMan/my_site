package top.pin90.pin.base.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import top.pin90.pin.base.pojo.Category;

public interface CategoryDao extends JpaRepository<Category,Long>, JpaSpecificationExecutor<CategoryDao> {
}
