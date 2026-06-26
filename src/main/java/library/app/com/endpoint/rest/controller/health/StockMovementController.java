package library.app.com.endpoint.rest.controller.health;

import library.app.com.entity.StockMovement;
import library.app.com.service.StockMovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock-movements")
@RequiredArgsConstructor
public class StockMovementController {

    private final StockMovementService service;

    @GetMapping
    public List<StockMovement> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public StockMovement getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping("/by-book/{bookId}")
    public List<StockMovement> getByBookId(@PathVariable Long bookId) {
        return service.getByBookId(bookId);
    }
}
