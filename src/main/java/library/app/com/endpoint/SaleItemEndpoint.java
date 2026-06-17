package library.app.com.endpoint;


import library.app.com.repository.model.SaleItem;
import library.app.com.service.SaleItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale-items")
public class SaleItemEndpoint {

    private final SaleItemService service;

    public SaleItemEndpoint(SaleItemService service) {this.service = service;}

    @GetMapping
    public List<SaleItem> getAll() {return service.getAllSaleItems();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteSaleItem(String.valueOf(id));}
}