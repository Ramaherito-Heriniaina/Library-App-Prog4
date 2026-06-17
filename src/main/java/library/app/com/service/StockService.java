package library.app.com.service;


import library.app.com.repository.model.Stock;
import library.app.com.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public List<Stock> getAllStocks() {
        return repository.findAll();
    }

    public void deleteStock(String id) {repository.deleteById(Long.valueOf(id));}
}