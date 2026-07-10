package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.endpoint.rest.model.JInvoice;
import library.app.com.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

  private final InvoiceService service;

  @GetMapping
  public List<JInvoice> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public JInvoice getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
