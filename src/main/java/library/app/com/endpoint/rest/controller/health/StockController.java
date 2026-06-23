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

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return service.createOrUpdate(stock);
    }

    @PutMapping("/{id}")
    public Stock update(@PathVariable Long id, @RequestBody Stock stock) {
        stock.setId(id); // Assure la cohérence de l'ID avec l'URL
        return service.createOrUpdate(stock);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteById(id);
    }
}