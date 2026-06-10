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

    public Book save(Book book) {
        books.add(book);
        return book;
    }
}