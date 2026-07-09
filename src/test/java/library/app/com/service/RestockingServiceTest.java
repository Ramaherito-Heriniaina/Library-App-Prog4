package library.app.com.service;


import library.app.com.endpoint.rest.model.JRestocking;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.RestockingRepository;
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
class RestockingServiceTest {

    @Mock
    private RestockingRepository repository;

    @InjectMocks
    private RestockingService restockingService;

    @Test
    void getAll_ShouldReturnList() {
        JRestocking jRestocking = new JRestocking();
        Page<JRestocking> page = new PageImpl<>(List.of(jRestocking));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<JRestocking> result = restockingService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnJRestocking_WhenExists() {
        Long id = 1L;
        JRestocking jRestocking = new JRestocking();
        doReturn(Optional.of(jRestocking)).when(repository).findById(id);

        JRestocking result = restockingService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> restockingService.getById(id));
    }
}