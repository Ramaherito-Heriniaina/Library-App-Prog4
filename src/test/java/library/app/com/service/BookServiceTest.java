package library.app.com.service;

import library.app.com.endpoint.rest.model.JBook;
import library.app.com.entity.Book;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.BookRepository;
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
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService bookService;

    @Test
    void getAll_ShouldReturnList() {

        JBook jBook = new JBook();

        Page<JBook> page = new PageImpl<>(List.of(jBook));


        when(repository.findAll(any(Pageable.class))).thenReturn(page);


        List<Book> result = bookService.getAll(0, 10);

        assertEquals(1, result.size());
    }

    @Test
    void getById_ShouldReturnBook_WhenExists() {
        Long id = 1L;
        JBook jBook = new JBook();
        when(repository.findById(id)).thenReturn(Optional.of(jBook));

        Book result = bookService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowException_WhenNotFound() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> bookService.getById(id));
    }
}