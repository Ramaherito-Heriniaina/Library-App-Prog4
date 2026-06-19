package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JSupplier;
import library.app.com.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService service;

    @GetMapping
    public List<JSupplier> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public JSupplier getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
