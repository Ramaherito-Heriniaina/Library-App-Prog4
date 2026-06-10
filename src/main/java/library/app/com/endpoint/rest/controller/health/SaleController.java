package library.app.com.endpoint.rest.controller.health;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    public ResponseEntity<List<SaleDTO>> getAll() {
        return ResponseEntity.ok(saleService.findAllDTO());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SaleDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(saleService.findByIdDTO(id));
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<SaleDTO>> getByCustomer(@PathVariable Long customerId) {
        return ResponseEntity.ok(
            saleService.findByCustomer(customerId).stream()
                .map(saleService::toDTO).toList()
        );
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<SaleDTO>> getByStatus(@PathVariable Sale.SaleStatus status) {
        return ResponseEntity.ok(
            saleService.findByStatus(status).stream()
                .map(saleService::toDTO).toList()
        );
    }

    @GetMapping("/range")
    public ResponseEntity<List<SaleDTO>> getByDateRange(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return ResponseEntity.ok(
            saleService.findByDateRange(from, to).stream()
                .map(saleService::toDTO).toList()
        );
    }
}
