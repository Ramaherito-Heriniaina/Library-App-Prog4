package library.app.com.endpoint.rest.controller.health;

import library.app.com.entity.Stock;
import library.app.com.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService service;

    @GetMapping
    public List<Stock> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int pageSize) {
        return service.getAll(page, pageSize);
    }

    @GetMapping("/{id}")
    public Stock getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
