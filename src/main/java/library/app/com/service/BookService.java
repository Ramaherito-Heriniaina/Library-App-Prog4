package library.app.com.service;

import com.librairie.dto.BookDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    public Book findById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
    }

    public Book findByIsbn(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new RuntimeException("Book not found with isbn: " + isbn));
    }

    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Book> findByAuthor(Long authorId) {
        return bookRepository.findByAuthorsId(authorId);
    }

    public List<Book> findByCategory(Long categoryId) {
        return bookRepository.findByCategoriesId(categoryId);
    }

    // DTO mapping
    public BookDTO toDTO(Book book) {
        return BookDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .publicationDate(book.getPublicationDate())
                .priceIncludingTax(book.getPriceIncludingTax())
                .language(book.getLanguage())
                .format(book.getFormat())
                .publisher(book.getPublisher() != null ?
                    PublisherService.toDTO(book.getPublisher()) : null)
                .authors(book.getAuthors() != null ?
                    book.getAuthors().stream().map(AuthorService::toDTO).collect(Collectors.toList()) : null)
                .categories(book.getCategories() != null ?
                    book.getCategories().stream().map(CategoryService::toDTO).collect(Collectors.toList()) : null)
                .build();
    }

    public List<BookDTO> findAllDTO() {
        return findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public BookDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
