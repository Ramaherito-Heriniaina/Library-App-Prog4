package library.app.com.repository;

import library.app.com.endpoint.rest.model.JPublisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<JPublisher, Long> {
}
