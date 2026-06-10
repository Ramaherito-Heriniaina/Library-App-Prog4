package library.app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByBookId(Long bookId);
    List<Stock> findByQuantityLessThanEqual(Integer threshold); // livres en rupture
}
