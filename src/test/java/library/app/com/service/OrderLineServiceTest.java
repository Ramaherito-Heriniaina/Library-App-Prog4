package library.app.com.service;


import library.app.com.endpoint.rest.model.JOrderLine;
import library.app.com.entity.OrderLine;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.OrderLineRepository;
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
class OrderLineServiceTest {

    @Mock
    private OrderLineRepository repository;

    @InjectMocks
    private OrderLineService orderLineService;

    @Test
    void getAll_ShouldReturnList() {
        JOrderLine jOrderLine = new JOrderLine();
        Page<JOrderLine> page = new PageImpl<>(List.of(jOrderLine));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<OrderLine> result = orderLineService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnOrderLine_WhenExists() {
        Long id = 1L;
        JOrderLine jOrderLine = new JOrderLine();
        doReturn(Optional.of(jOrderLine)).when(repository).findById(id);

        OrderLine result = orderLineService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> orderLineService.getById(id));
    }
}