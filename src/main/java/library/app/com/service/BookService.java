package library.app.com.service;

import java.util.List;
import library.app.com.endpoint.rest.model.JBook;
import library.app.com.entity.Book;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

  private final BookRepository repository;

  public Book create(JBook book) {

    return Book.from(repository.save(book));
  }

  public List<Book> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).stream().map(Book::from).toList();
  }

  public Book getById(Long id) {
    return repository
            .findById(id)
            .map(Book::from)
            .orElseThrow(() -> new NotFoundException("Book #" + id + " not found"));
  }

  public JBook updateBook(Long id, JBook book) {
    JBook existingBook =
            repository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    existingBook.setTitle(book.getTitle());
    existingBook.setIsbn(book.getIsbn());
    existingBook.setPriceExTax(book.getPriceExTax());
    existingBook.setPriceInclTax(book.getPriceInclTax());
    existingBook.setVat(book.getVat());
    existingBook.setPageCount(book.getPageCount());
    existingBook.setLanguage(book.getLanguage());
    existingBook.setFormat(book.getFormat());

    return repository.save(existingBook);
  }

  public void deleteBook(Long id) {

    if (!repository.existsById(id)) {

      throw new RuntimeException("Book not found");
    }

    repository.deleteById(id);
  }
}