package library.app.com.repository;

import library.app.com.endpoint.rest.model.JCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<JCart, Long> {}
