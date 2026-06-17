package library.app.com.service;


import library.app.com.repository.model.Sale;
import library.app.com.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {

    private final SaleRepository repository;

    public SaleService(SaleRepository repository) {this.repository = repository;}

    public List<Sale> getAllSales() {return repository.findAll();}

    public void deleteSale(String id) {repository.deleteById(Long.valueOf(id));}
}