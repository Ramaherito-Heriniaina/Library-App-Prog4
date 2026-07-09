package library.app.com.repository;

import library.app.com.endpoint.rest.model.JInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<JInvoice, Long> {}
