package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.LowStockResult;
import library.app.com.entity.Stock;
import library.app.com.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stocks")
@RequiredArgsConstructor
public class StockController {

  private final StockService service;

  // ===== READ =====

  @GetMapping
  public List<Stock> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Stock getById(@PathVariable Long id) {
    return service.getById(id);
  }

  @GetMapping("/all")
  public List<Stock> getAllStocks() {
    return service.getAllStocks();
  }

  @GetMapping("/by-book/{bookId}")
  public Stock getByBook(@PathVariable Long bookId) {
    return service.getStockByBookId(bookId);
  }

  @GetMapping("/by-book/{bookId}/edition/{format}")
  public Stock getByBookAndFormat(@PathVariable Long bookId, @PathVariable String format) {
    return service.getStockByBookIdAndFormat(bookId, format);
  }

  @GetMapping("/low-stock")
  public List<LowStockResult> getLowStockBooks(@RequestParam(defaultValue = "3") int threshold) {
    return service.getLowStockBooks(threshold);
  }

  // ===== CREATE =====

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Stock create(@RequestBody Stock stock) {
    return service.create(stock);
  }

  // ===== UPDATE (location + alertThreshold uniquement, jamais quantity) =====

  @PutMapping("/{id}")
  public Stock update(@PathVariable Long id, @RequestBody Stock stock) {
    return service.update(id, stock);
  }
}
