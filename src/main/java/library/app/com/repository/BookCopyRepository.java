package library.app.com.repository;

import library.app.com.repository.model.BookCopy;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookCopyRepository {

    private final List<BookCopy> bookCopies = new ArrayList<>();

    public List<BookCopy> findAll() {
        return bookCopies;
    }

    public void deleteById(Long id) {
        bookCopies.removeIf(bookCopies -> bookCopies.getId().equals(id));
    }
}