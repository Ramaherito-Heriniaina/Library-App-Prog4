package library.app.com.service;


import library.app.com.endpoint.rest.model.JCustomer;
import library.app.com.entity.Customer;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.CustomerRepository;
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
class CustomerServiceTest {

    @Mock
    private CustomerRepository repository;

    @InjectMocks
    private CustomerService customerService;

    @Test
    void getAll_ShouldReturnList() {
        JCustomer jCustomer = new JCustomer();
        Page<JCustomer> page = new PageImpl<>(List.of(jCustomer));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<Customer> result = customerService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnCustomer_WhenExists() {
        Long id = 1L;
        JCustomer jCustomer = new JCustomer();
        doReturn(Optional.of(jCustomer)).when(repository).findById(id);

        Customer result = customerService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> customerService.getById(id));
    }
}