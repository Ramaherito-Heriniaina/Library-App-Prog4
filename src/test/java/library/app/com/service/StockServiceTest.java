package library.app.com.service;


import library.app.com.endpoint.rest.model.JStock;
import library.app.com.entity.Stock;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.StockRepository;
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
class StockServiceTest {

    @Mock
    private StockRepository repository;

    @InjectMocks
    private StockService stockService;

    @Test
    void getAll_ShouldReturnList() {
        JStock jStock = new JStock();
        Page<JStock> page = new PageImpl<>(List.of(jStock));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<Stock> result = stockService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnStock_WhenExists() {
        Long id = 1L;
        JStock jStock = new JStock();
        doReturn(Optional.of(jStock)).when(repository).findById(id);

        Stock result = stockService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> stockService.getById(id));
    }
}