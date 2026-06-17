package library.app.com.endpoint;


import library.app.com.repository.model.Invoice;
import library.app.com.service.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceEndpoint {

    private final InvoiceService service;

    public InvoiceEndpoint(InvoiceService service) {this.service = service;}

    @GetMapping
    public List<Invoice> getAll() {return service.getAllInvoices();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteInvoice(String.valueOf(id));}
}