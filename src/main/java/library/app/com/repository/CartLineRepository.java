package library.app.com.repository;

import library.app.com.endpoint.rest.model.JCartLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartLineRepository extends JpaRepository<JCartLine, Long> {
}
