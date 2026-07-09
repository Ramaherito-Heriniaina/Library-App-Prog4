package library.app.com.service;


import library.app.com.endpoint.rest.model.JPublisher;
import library.app.com.entity.Publisher;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.PublisherRepository;
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
class PublisherServiceTest {

    @Mock
    private PublisherRepository repository;

    @InjectMocks
    private PublisherService publisherService;

    @Test
    void getAll_ShouldReturnList() {
        JPublisher jPublisher = new JPublisher();
        Page<JPublisher> page = new PageImpl<>(List.of(jPublisher));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<Publisher> result = publisherService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnPublisher_WhenExists() {
        Long id = 1L;
        JPublisher jPublisher = new JPublisher();
        doReturn(Optional.of(jPublisher)).when(repository).findById(id);

        Publisher result = publisherService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> publisherService.getById(id));
    }
}