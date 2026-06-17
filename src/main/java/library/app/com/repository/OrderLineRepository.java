package library.app.com.repository;

import library.app.com.endpoint.rest.model.JOrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<JOrderLine, Long> {
}
