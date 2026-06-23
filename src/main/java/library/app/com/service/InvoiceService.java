package library.app.com.service;

import library.app.com.endpoint.rest.model.JInvoice;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository repository;

    public List<JInvoice> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize)).toList();
    }

    public JInvoice getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Invoice #" + id + " not found"));
    }

    public JInvoice createOrUpdate(JInvoice invoice) {
        return repository.save(invoice);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Invoice #" + id + " not found");
        }
        repository.deleteById(id);
    }
}