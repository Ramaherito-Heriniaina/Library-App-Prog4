package library.app.com.endpoint.rest.controller.health;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/stocks")
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAll() {
        return ResponseEntity.ok(stockService.findAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StockDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(stockService.findByIdDTO(id));
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<StockDTO> getByBook(@PathVariable Long bookId) {
        return ResponseEntity.ok(stockService.toDTO(stockService.findByBook(bookId)));
    }

    @GetMapping("/low")
    public ResponseEntity<List<StockDTO>> getLowStock() {
        return ResponseEntity.ok(
            stockService.findLowStock().stream()
                .map(stockService::toDTO).toList()
        );
    }
}
