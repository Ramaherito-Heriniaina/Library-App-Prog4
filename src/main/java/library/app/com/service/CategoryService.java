package library.app.com.service;

import com.librairie.dto.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    public List<Category> findRootCategories() {
        return categoryRepository.findByParentIsNull();
    }

    public List<Category> findChildren(Long parentId) {
        return categoryRepository.findByParentId(parentId);
    }

    public static CategoryDTO toDTO(Category category) {
        return CategoryDTO.builder()
                .id(category.getId())
                .name(category.getName())
                .description(category.getDescription())
                .build();
    }

    public List<CategoryDTO> findAllDTO() {
        return findAll().stream().map(CategoryService::toDTO).collect(Collectors.toList());
    }

    public CategoryDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
