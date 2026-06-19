package library.app.com.repository;

import library.app.com.endpoint.rest.model.JSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<JSupplier, Long> {
}
