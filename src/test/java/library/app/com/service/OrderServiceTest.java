package library.app.com.service;


import library.app.com.endpoint.rest.model.JOrder;
import library.app.com.entity.Order;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.OrderRepository;
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
class OrderServiceTest {

    @Mock
    private OrderRepository repository;

    @InjectMocks
    private OrderService orderService;

    @Test
    void getAll_ShouldReturnList() {
        JOrder jOrder = new JOrder();
        Page<JOrder> page = new PageImpl<>(List.of(jOrder));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<Order> result = orderService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnOrder_WhenExists() {
        Long id = 1L;
        JOrder jOrder = new JOrder();
        doReturn(Optional.of(jOrder)).when(repository).findById(id);

        Order result = orderService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> orderService.getById(id));
    }
}