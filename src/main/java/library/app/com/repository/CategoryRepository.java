package library.app.com.repository;


import library.app.com.repository.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository {

    private final List<Category> categories = new ArrayList<>();

    public List<Category> findAll() {
        return categories;
    }

    public Category save(Category category) {
        categories.add(category);
        return category;
    }
}