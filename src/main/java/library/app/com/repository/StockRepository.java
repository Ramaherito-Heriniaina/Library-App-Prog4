package library.app.com.repository;

import library.app.com.repository.model.Stock;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StockRepository {

    private final List<Stock> Stocks = new ArrayList<>();

    public List<Stock> findAll() {
        return Stocks;
    }

    public void deleteById(Long id) {
        Stocks.removeIf(Stock -> Stock.getId().equals(id));
    }
}