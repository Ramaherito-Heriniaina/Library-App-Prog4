package library.app.com.service;


import library.app.com.repository.model.Payment;
import library.app.com.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {this.repository = repository;}

    public List<Payment> getAllPayments() {return repository.findAll();}

    public void deletePayment(String id) {repository.deleteById(Long.valueOf(id));}
}