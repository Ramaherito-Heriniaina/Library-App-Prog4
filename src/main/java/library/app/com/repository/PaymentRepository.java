package library.app.com.repository;

import library.app.com.endpoint.rest.model.JPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<JPayment, Long> {}
