package library.app.com.service;


import library.app.com.repository.model.Customer;
import library.app.com.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {this.repository = repository;}

    public List<Customer> getAllCustomers() {return repository.findAll();}

    public void deleteCustomer(String id) {repository.deleteById(Long.valueOf(id));}
}