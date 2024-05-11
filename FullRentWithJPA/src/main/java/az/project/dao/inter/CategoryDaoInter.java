package az.project.dao.inter;

import az.project.entity.Category;
import java.util.List;

public interface CategoryDaoInter {

    void update(Category cat);
    void insert(Category cat);
    void delete(int id);
    Category getCategoryById(int id);
    List<Category> getAllCategory();
}
