package library.app.com.endpoint.rest.controller.health;

import library.app.com.endpoint.rest.model.JRestocking;
import library.app.com.service.RestockingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restockings")
@RequiredArgsConstructor
public class RestockingController {

    private final RestockingService service;

    @GetMapping
    public List<JRestocking> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public JRestocking getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public JRestocking create(@RequestBody JRestocking restocking) {
        return service.createOrUpdate(restocking);
    }

    @PutMapping("/{id}")
    public JRestocking update(@PathVariable Long id, @RequestBody JRestocking restocking) {
        restocking.setId(id); // Assure la cohérence de l'ID avec l'URL
        return service.createOrUpdate(restocking);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}