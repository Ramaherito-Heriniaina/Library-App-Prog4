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
}
