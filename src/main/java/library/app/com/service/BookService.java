package library.app.com.service;

import library.app.com.entity.Book;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository repository;

    public List<Book> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Book::from)
                .toList();
    }

    public Book getById(Long id) {
        return repository.findById(id)
                .map(Book::from)
                .orElseThrow(() -> new NotFoundException("Book #" + id + " not found"));
    }
}
