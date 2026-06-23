package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JInvoice;
import library.app.com.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {

    private final InvoiceService service;

    @GetMapping
    public List<JInvoice> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public JInvoice getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JInvoice create(@RequestBody JInvoice invoice) {
        return service.createOrUpdate(invoice);
    }

    @PutMapping("/{id}")
    public JInvoice update(@PathVariable Long id, @RequestBody JInvoice invoice) {
        invoice.setId(id); // Assure la cohérence de l'ID avec l'URL
        return service.createOrUpdate(invoice);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}