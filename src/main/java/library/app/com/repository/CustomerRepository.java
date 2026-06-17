package library.app.com.repository;

import library.app.com.repository.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {

    private final List<Customer> Customers = new ArrayList<>();

    public List<Customer> findAll() {
        return Customers;
    }

    public void deleteById(Long id) {
        Customers.removeIf(Customer -> Customer.getId().equals(id));
    }
}