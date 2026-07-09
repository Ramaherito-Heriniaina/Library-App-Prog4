package library.app.com.service;

import library.app.com.endpoint.rest.model.JSupplier;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.SupplierRepository;
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
class SupplierServiceTest {

    @Mock
    private SupplierRepository repository;

    @InjectMocks
    private SupplierService supplierService;

    @Test
    void getAll_ShouldReturnList() {
        JSupplier jSupplier = new JSupplier();
        Page<JSupplier> page = new PageImpl<>(List.of(jSupplier));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<JSupplier> result = supplierService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnJSupplier_WhenExists() {
        Long id = 1L;
        JSupplier jSupplier = new JSupplier();
        doReturn(Optional.of(jSupplier)).when(repository).findById(id);

        JSupplier result = supplierService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> supplierService.getById(id));
    }
}