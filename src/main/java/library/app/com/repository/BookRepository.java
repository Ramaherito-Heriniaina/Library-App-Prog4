package library.app.com.repository;

import library.app.com.endpoint.rest.model.JBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<JBook, Long> {}
