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
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

    @Mock
    private BookRepository repository;

    @InjectMocks
    private BookService bookService;

    @Test
    void getAll_ReturnsList() {
        when(repository.findAll(any(Pageable.class))).thenReturn(new PageImpl<>(List.of(new Book())));

        List<Book> books = bookService.getAll(0, 10);

        assertEquals(1, books.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_Found() {
        Long id = 1L;
        when(repository.findById(id)).thenReturn(Optional.of(new Book()));

        Book book = bookService.getById(id);

        assertNotNull(book);
    }

    @Test
    void getById_NotFound_ThrowsException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());
        assertThrows(NotFoundException.class, () -> bookService.getById(1L));
    }

    @Test
    void updateBook_Success() {
        Long id = 1L;
        JBook existing = new JBook();
        JBook updatedData = new JBook();
        updatedData.setTitle("New Title");

        when(repository.findById(id)).thenReturn(Optional.of(existing));
        when(repository.save(any(JBook.class))).thenReturn(updatedData);

        JBook result = bookService.updateBook(id, updatedData);

        assertEquals("New Title", result.getTitle());
        verify(repository).save(existing);
    }

    @Test
    void deleteBook_Success() {
        Long id = 1L;
        when(repository.existsById(id)).thenReturn(true);

        bookService.deleteBook(id);

        verify(repository, times(1)).deleteById(id);
    }

    @Test
    void deleteBook_ThrowsException_WhenNotFound() {
        Long id = 99L;
        when(repository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> bookService.deleteBook(id));
        verify(repository, never()).deleteById(any());
    }
}