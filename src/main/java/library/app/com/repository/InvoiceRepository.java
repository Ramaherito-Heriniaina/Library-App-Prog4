package library.app.com.repository;

import library.app.com.repository.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InvoiceRepository {

    private final List<Invoice> Invoices = new ArrayList<>();

    public List<Invoice> findAll() {
        return Invoices;
    }

    public void deleteById(Long id) {
        Invoices.removeIf(Invoice -> Invoice.getId().equals(id));
    }
}