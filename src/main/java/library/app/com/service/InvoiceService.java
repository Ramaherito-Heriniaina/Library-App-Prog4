package library.app.com.service;


import library.app.com.repository.model.Invoice;
import library.app.com.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {

    private final InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {this.repository = repository;}

    public List<Invoice> getAllInvoices() {return repository.findAll();}

    public void deleteInvoice(String id) {repository.deleteById(Long.valueOf(id));}
}