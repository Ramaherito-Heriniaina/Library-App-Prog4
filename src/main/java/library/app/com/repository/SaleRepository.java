package library.app.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByCustomerId(Long customerId);
    List<Sale> findByStatus(Sale.SaleStatus status);
    List<Sale> findBySaleDateBetween(LocalDateTime from, LocalDateTime to);
}
