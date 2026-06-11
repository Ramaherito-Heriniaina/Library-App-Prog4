package library.app.com.service;

import library.app.com.entity.Book;
import library.app.com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public Book updateBook(String id, Book newBook) {

        Book existingBook = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        existingBook.setTitle(newBook.getTitle());
        existingBook.setIsbn(newBook.getIsbn());
        existingBook.setPrice(newBook.getPrice());
        existingBook.setLanguage(newBook.getLanguage());
        existingBook.setGenre(newBook.getGenre());
        existingBook.setPublishedDate(newBook.getPublishedDate());

        return bookRepository.save(existingBook);
    }
}