package library.app.com.service;

import library.app.com.entity.Author;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.AuthorRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @Test
    void getAll_ShouldReturnList() {

        Author author = new Author();
        Page<Author> page = new PageImpl<>(List.of(author));
        when(authorRepository.findAll(any(PageRequest.class)));

        List<Author> result = authorService.getAll(0, 10);

        assertEquals(1, result.size());
    }

    @Test
    void getById_ShouldReturnAuthor_WhenExists() {

        Long id = 1L;
        Author author = new Author();
        when(authorRepository.findById(id));

        Author result = authorService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowException_WhenNotFound() {

        Long id = 1L;
        when(authorRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> authorService.getById(id));
    }
}