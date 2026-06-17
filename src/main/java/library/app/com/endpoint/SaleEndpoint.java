package library.app.com.endpoint;


import library.app.com.repository.model.Sale;
import library.app.com.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleEndpoint {

    private final SaleService service;

    public SaleEndpoint(SaleService service) {this.service = service;}

    @GetMapping
    public List<Sale> getAll() {return service.getAllSales();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteSale(String.valueOf(id));}
}