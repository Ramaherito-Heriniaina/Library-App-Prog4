package library.app.com.service;

import library.app.com.entity.Customer;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;

    public List<Customer> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Customer::from)
                .toList();
    }

    public Customer getById(Long id) {
        return repository.findById(id)
                .map(Customer::from)
                .orElseThrow(() -> new NotFoundException("Customer #" + id + " not found"));
    }
}
