package library.app.com.service;

import java.util.List;
import library.app.com.endpoint.rest.model.JInvoice;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InvoiceService {

  private final InvoiceRepository repository;

  public List<JInvoice> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).toList();
  }

  public JInvoice getById(Long id) {
    return repository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Invoice #" + id + " not found"));
  }
}
