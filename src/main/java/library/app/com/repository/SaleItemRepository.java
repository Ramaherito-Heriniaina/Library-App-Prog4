package library.app.com.repository;

import library.app.com.repository.model.SaleItem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SaleItemRepository {

    private final List<SaleItem> SaleItems = new ArrayList<>();

    public List<SaleItem> findAll() {
        return SaleItems;
    }

    public void deleteById(Long id) { SaleItems.removeIf(SaleItem -> SaleItem.getId().equals(id));
    }
}