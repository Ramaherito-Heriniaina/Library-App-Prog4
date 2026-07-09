package library.app.com.service;

import library.app.com.endpoint.rest.model.JCart;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.CartRepository;
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
class CartServiceTest {

    @Mock
    private CartRepository repository;

    @InjectMocks
    private CartService cartService;

    @Test
    void getAll_ReturnsList() {

        JCart cart = new JCart();
        Page<JCart> page = new PageImpl<>(List.of(cart));
        when(repository.findAll(any(Pageable.class))).thenReturn(page);

        List<JCart> result = cartService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository, times(1)).findAll(any(Pageable.class));
    }

    @Test
    void getById_ReturnsCart_WhenExists() {

        Long id = 1L;
        JCart cart = new JCart();
        when(repository.findById(id)).thenReturn(Optional.of(cart));

        JCart result = cartService.getById(id);

        assertNotNull(result);
        assertEquals(cart, result);
    }

    @Test
    void getById_ThrowsNotFoundException_WhenDoesNotExist() {

        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> cartService.getById(id));
    }
}