package library.app.com.service;

import java.util.List;
import library.app.com.endpoint.rest.model.JStock;
import library.app.com.entity.LowStockResult;
import library.app.com.entity.Stock;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.StockMovementRepository;
import library.app.com.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockService {

  private final StockRepository repository;
  private final StockMovementRepository stockMovementRepository;

  private static final int DEFAULT_LOW_STOCK_THRESHOLD = 3;

  // ===== READ de base =====

  public List<Stock> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).stream()
        .map(this::toStockWithComputedQuantity)
        .toList();
  }

  public Stock getById(Long id) {
    JStock stock =
        repository
            .findById(id)
            .orElseThrow(() -> new NotFoundException("Stock #" + id + " not found"));
    return toStockWithComputedQuantity(stock);
  }

  // ===== Fonctionnalité 1a : stock d'un livre, toutes éditions confondues =====

  public Stock getStockByBookId(Long bookId) {
    JStock stock =
        repository
            .findByBookId(bookId)
            .orElseThrow(() -> new NotFoundException("Stock for Book #" + bookId + " not found"));
    return toStockWithComputedQuantity(stock);
  }

  public List<Stock> getAllStocks() {
    return repository.findAll().stream().map(this::toStockWithComputedQuantity).toList();
  }

  // ===== Fonctionnalité 1b : stock d'une édition spécifique (par format) =====

  public Stock getStockByBookIdAndFormat(Long bookId, String format) {
    JStock stock =
        repository
            .findByBookId(bookId)
            .orElseThrow(() -> new NotFoundException("Stock for Book #" + bookId + " not found"));

    int computedQuantity = stockMovementRepository.computeStockQuantityByFormat(bookId, format);

    return Stock.from(stock, computedQuantity);
  }

  // ===== Fonctionnalité 2 : produits avec stock bas =====

  /** Retourne les livres dont le stock calculé est <= threshold. Par défaut threshold = 3. */
  public List<LowStockResult> getLowStockBooks(int threshold) {
    return repository.findAll().stream()
        .map(
            stock -> {
              Long bookId = stock.getBook() != null ? stock.getBook().getId() : null;
              int quantity =
                  bookId != null ? stockMovementRepository.computeStockQuantity(bookId) : 0;

              return LowStockResult.builder()
                  .bookId(bookId)
                  .title(stock.getBook() != null ? stock.getBook().getTitle() : null)
                  .isbn(stock.getBook() != null ? stock.getBook().getIsbn() : null)
                  .currentStock(quantity)
                  .alertThreshold(stock.getAlertThreshold())
                  .location(stock.getLocation())
                  .build();
            })
        .filter(result -> result.getCurrentStock() <= threshold)
        .toList();
  }

  // ===== Helper interne =====

  private Stock toStockWithComputedQuantity(JStock stock) {
    Long bookId = stock.getBook() != null ? stock.getBook().getId() : null;
    int computedQuantity =
        bookId != null ? stockMovementRepository.computeStockQuantity(bookId) : 0;
    return Stock.from(stock, computedQuantity);
  }
}
