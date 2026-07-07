package library.app.com.endpoint.rest.controller.health;


import library.app.com.endpoint.rest.model.JSale;
import library.app.com.service.SaleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SaleController {
    private final SaleService saleService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public JSale createSale(@RequestBody JSale sale) {

        return saleService.createSale(sale);
    }

    @GetMapping
    public List<JSale> getAllSales() {

        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public JSale getSaleById(
            @PathVariable Long id
    ) {

        return saleService.getSaleById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSale(
            @PathVariable Long id
    ) {

        saleService.deleteSale(id);
    }
}
