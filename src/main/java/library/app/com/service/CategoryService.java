package library.app.com.service;

import jakarta.persistence.Entity;
import library.app.com.entity.Category;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CategoryService {

    private final CategoryRepository repository;

    public List<Category> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Category::from)
                .toList();
    }

    public Category getById(Long id) {
        return repository.findById(id)
                .map(Category::from)
                .orElseThrow(() -> new NotFoundException("Category #" + id + " not found"));
    }

    public Category createOrUpdate(Category category) {
        return repository.save(category);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Category #" + id + " not found");
        }
        repository.deleteById(id);
    }
}