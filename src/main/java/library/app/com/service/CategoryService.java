package library.app.com.service;


import library.app.com.repository.model.Category;
import library.app.com.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        return repository.findAll();
    }

    public void deleteCategory(Long id) { repository.deleteById(id); }
}