package library.app.com.service;


import library.app.com.endpoint.rest.model.JPayment;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.PaymentRepository;
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
class PaymentServiceTest {

    @Mock
    private PaymentRepository repository;

    @InjectMocks
    private PaymentService paymentService;

    @Test
    void getAll_ShouldReturnList() {
        JPayment jPayment = new JPayment();
        Page<JPayment> page = new PageImpl<>(List.of(jPayment));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<JPayment> result = paymentService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnJPayment_WhenExists() {
        Long id = 1L;
        JPayment jPayment = new JPayment();
        doReturn(Optional.of(jPayment)).when(repository).findById(id);

        JPayment result = paymentService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> paymentService.getById(id));
    }
}