package library.app.com.service;


import library.app.com.endpoint.rest.model.JReview;
import library.app.com.entity.Review;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.ReviewRepository;
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
class ReviewServiceTest {

    @Mock
    private ReviewRepository repository;

    @InjectMocks
    private ReviewService reviewService;

    @Test
    void getAll_ShouldReturnList() {
        JReview jReview = new JReview();
        Page<JReview> page = new PageImpl<>(List.of(jReview));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<Review> result = reviewService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnReview_WhenExists() {
        Long id = 1L;
        JReview jReview = new JReview();
        doReturn(Optional.of(jReview)).when(repository).findById(id);

        Review result = reviewService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> reviewService.getById(id));
    }
}