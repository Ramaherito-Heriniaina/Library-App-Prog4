package library.app.com.repository;

import library.app.com.endpoint.rest.model.JSale;
import library.app.com.entity.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<JSale, Long> {
}
