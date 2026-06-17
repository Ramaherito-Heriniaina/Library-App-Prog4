package library.app.com.endpoint;


import library.app.com.repository.model.Customer;
import library.app.com.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerEndpoint {

    private final CustomerService service;

    public CustomerEndpoint(CustomerService service) {this.service = service;}

    @GetMapping
    public List<Customer> getAll() {return service.getAllCustomers();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteCustomer(String.valueOf(id));}
}