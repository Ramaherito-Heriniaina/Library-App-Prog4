package library.app.com.repository;

import library.app.com.endpoint.rest.model.JCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<JCategory, Long> {}
