package library.app.com.endpoint;


import library.app.com.repository.model.Payment;
import library.app.com.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentEndpoint {

    private final PaymentService service;

    public PaymentEndpoint(PaymentService service) {this.service = service;}

    @GetMapping
    public List<Payment> getAll() {return service.getAllPayments();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deletePayment(String.valueOf(id));}
}