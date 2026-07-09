package library.app.com.service;


import library.app.com.endpoint.rest.model.JPromotion;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.PromotionRepository;
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
class PromotionServiceTest {

    @Mock
    private PromotionRepository repository;

    @InjectMocks
    private PromotionService promotionService;

    @Test
    void getAll_ShouldReturnList() {
        JPromotion jPromotion = new JPromotion();
        Page<JPromotion> page = new PageImpl<>(List.of(jPromotion));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<JPromotion> result = promotionService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnJPromotion_WhenExists() {
        Long id = 1L;
        JPromotion jPromotion = new JPromotion();
        doReturn(Optional.of(jPromotion)).when(repository).findById(id);

        JPromotion result = promotionService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> promotionService.getById(id));
    }
}