package library.app.com.repository;

import java.util.List;
import java.util.Optional;
import library.app.com.entity.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookCopyRepository extends JpaRepository<BookCopy, Long> {

  List<BookCopy> findByBookId(Long bookId);

  Optional<BookCopy> findByBookIdAndFormat(Long bookId, String format);
}
