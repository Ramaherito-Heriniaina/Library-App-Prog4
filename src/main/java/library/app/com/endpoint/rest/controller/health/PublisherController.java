package library.app.com.endpoint.rest.controller.health;

import library.app.com.entity.Publisher;
import library.app.com.service.PublisherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
@RequiredArgsConstructor
public class PublisherController {

    private final PublisherService service;

    @GetMapping
    public List<Publisher> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public Publisher getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PostMapping
    public Publisher create(@RequestBody Publisher publisher) {
        return service.createOrUpdate(publisher);
    }

    @PutMapping("/{id}")
    public Publisher update(@PathVariable Long id, @RequestBody Publisher publisher) {
        publisher.setId(id); // Assure la cohérence de l'ID avec l'URL
        return service.createOrUpdate(publisher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}