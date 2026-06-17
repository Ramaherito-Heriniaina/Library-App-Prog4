package library.app.com.repository;

import library.app.com.repository.model.Sale;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleRepository {

    private final List<Sale> Sales = new ArrayList<>();

    public List<Sale> findAll() {
        return Sales;
    }

    public void deleteById(Long id) {
        Sales.removeIf(Sale -> Sale.getId().equals(id));
    }
}