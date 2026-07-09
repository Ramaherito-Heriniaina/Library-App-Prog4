package library.app.com.service;

import library.app.com.endpoint.rest.model.JCategory;
import library.app.com.entity.Category;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository repository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void getAll_ReturnsList() {
        JCategory jCategory = new JCategory();
        Page<JCategory> page = new PageImpl<>(List.of(jCategory));
        when(repository.findAll(any(Pageable.class))).thenReturn(page);

        List<Category> result = categoryService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ReturnsCategory_WhenExists() {
        Long id = 1L;
        JCategory jCategory = new JCategory();
        when(repository.findById(id)).thenReturn(Optional.of(jCategory));

        Category result = categoryService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ThrowsNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> categoryService.getById(id));
    }
}