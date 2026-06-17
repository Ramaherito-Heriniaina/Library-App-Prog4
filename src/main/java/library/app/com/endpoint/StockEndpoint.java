package library.app.com.endpoint;


import library.app.com.repository.model.Stock;
import library.app.com.service.StockService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stocks")
public class StockEndpoint {

    private final StockService service;

    public StockEndpoint(StockService service) {this.service = service;}

    @GetMapping
    public List<Stock> getAll() {return service.getAllStocks();}


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteStock(String.valueOf(id));}
}