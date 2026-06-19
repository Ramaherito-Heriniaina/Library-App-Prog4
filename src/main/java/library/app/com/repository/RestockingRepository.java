package library.app.com.repository;

import library.app.com.endpoint.rest.model.JRestocking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestockingRepository extends JpaRepository<JRestocking, Long> {
}
