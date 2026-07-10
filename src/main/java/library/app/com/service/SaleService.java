package library.app.com.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import library.app.com.endpoint.rest.model.JSale;
import library.app.com.endpoint.rest.model.JSaleItem;
import library.app.com.repository.SaleRepository;
import library.app.com.repository.projection.RevenueByCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaleService {

  private final SaleRepository saleRepository;

  // Enregistrer une vente
  public JSale createSale(JSale sale) {

    BigDecimal total = BigDecimal.ZERO;

    for (JSaleItem item : sale.getItems()) {

      BigDecimal subtotal = item.getUnitPrice().multiply(BigDecimal.valueOf(item.getQuantity()));

      total = total.add(subtotal);

      // liaison entre sale et saleItem
      item.setSale(sale);
    }

    sale.setSaleDate(LocalDateTime.now());

    sale.setTotalAmount(total);

    return saleRepository.save(sale);
  }

  // Lister toutes les ventes
  public List<JSale> getAllSales() {

    return saleRepository.findAll();
  }

  public JSale getSaleById(Long id) {

    return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("Sale not found"));
  }

  public void deleteSale(Long id) {

    saleRepository.deleteById(id);
  }

  public List<RevenueByCategory> getRevenueByCategory() {

    return saleRepository.getRevenueByCategory();
  }
}