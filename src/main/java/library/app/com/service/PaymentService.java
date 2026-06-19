package library.app.com.service;

import library.app.com.endpoint.rest.model.JPayment;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public List<JPayment> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public JPayment getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment #" + id + " not found"));
    }
}
