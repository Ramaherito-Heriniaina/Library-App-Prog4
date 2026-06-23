package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JPayment;
import library.app.com.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService service;

    @GetMapping
    public List<JPayment> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public JPayment getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JPayment create(@RequestBody JPayment payment) {
        return service.createOrUpdate(payment);
    }

    @PutMapping("/{id}")
    public JPayment update(@PathVariable Long id, @RequestBody JPayment payment) {
        payment.setId(id);
        return service.createOrUpdate(payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}