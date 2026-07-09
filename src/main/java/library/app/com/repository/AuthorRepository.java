package library.app.com.repository;

import library.app.com.endpoint.rest.model.JAuthor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<JAuthor, Long> {}
