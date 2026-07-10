package library.app.com.repository;

import library.app.com.endpoint.rest.model.JStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<JStock, Long> {}
