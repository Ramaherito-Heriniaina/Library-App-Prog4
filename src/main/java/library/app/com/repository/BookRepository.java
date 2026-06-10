package library.app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIsbn(String isbn);
    List<Book> findByTitleContainingIgnoreCase(String title);
    List<Book> findByLanguage(String language);
    List<Book> findByPublisherId(Long publisherId);
    List<Book> findByAuthorsId(Long authorId);
    List<Book> findByCategoriesId(Long categoryId);
}
