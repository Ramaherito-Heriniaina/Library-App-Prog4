package library.app.com.repository;

import library.app.com.endpoint.rest.model.JSaleItem;
import library.app.com.entity.SaleItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleItemRepository  extends JpaRepository<JSaleItem, String> {
}
