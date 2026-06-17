package library.app.com.repository;

import library.app.com.repository.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository {

    private final List<Book> books = new ArrayList<>();

    public List<Book> findAll() {
        return books;
    }

    public void deleteById(Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}