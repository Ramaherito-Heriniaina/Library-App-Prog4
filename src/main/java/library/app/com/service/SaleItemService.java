package library.app.com.service;


import library.app.com.repository.model.SaleItem;
import library.app.com.repository.SaleItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleItemService {

    private final SaleItemRepository repository;

    public SaleItemService(SaleItemRepository repository) {this.repository = repository; }

    public List<SaleItem> getAllSaleItems() { return repository.findAll(); }

    public void deleteSaleItem(String id) { repository.deleteById(Long.valueOf(id)); }

}