package library.app.com.repository;

import library.app.com.repository.model.Payment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PaymentRepository {

    private final List<Payment> Payments = new ArrayList<>();

    public List<Payment> findAll() {
        return Payments;
    }

    public void deleteById(Long id) {
        Payments.removeIf(Payment -> Payment.getId().equals(id));
    }
}