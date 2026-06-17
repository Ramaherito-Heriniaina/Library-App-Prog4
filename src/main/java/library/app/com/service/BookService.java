package library.app.com.service;


import library.app.com.repository.model.Book;
import library.app.com.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public void deleteBook(Long id) { repository.deleteById(id); }
}