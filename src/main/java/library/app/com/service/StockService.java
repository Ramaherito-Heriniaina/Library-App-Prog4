package library.app.com.service;

import library.app.com.endpoint.rest.model.JBook;
import library.app.com.endpoint.rest.model.JStock;
import library.app.com.entity.LowStockResult;
import library.app.com.entity.Stock;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.BookRepository;
import library.app.com.repository.StockMovementRepository;
import library.app.com.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepository repository;
    private final StockMovementRepository stockMovementRepository;
    private final BookRepository bookRepository;

    // ===== READ =====

    public List<Stock> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(this::toStockWithComputedQuantity)
                .toList();
    }

    public Stock getById(Long id) {
        JStock stock = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Stock #" + id + " not found"));
        return toStockWithComputedQuantity(stock);
    }

    public Stock getStockByBookId(Long bookId) {
        JStock stock = repository.findByBookId(bookId)
                .orElseThrow(() -> new NotFoundException("Stock for Book #" + bookId + " not found"));
        return toStockWithComputedQuantity(stock);
    }

    public List<Stock> getAllStocks() {
        return repository.findAll()
                .stream()
                .map(this::toStockWithComputedQuantity)
                .toList();
    }

    public Stock getStockByBookIdAndFormat(Long bookId, String format) {
        JStock stock = repository.findByBookId(bookId)
                .orElseThrow(() -> new NotFoundException("Stock for Book #" + bookId + " not found"));
        int computedQuantity = stockMovementRepository
                .computeStockQuantityByFormat(bookId, format);
        return Stock.from(stock, computedQuantity);
    }

    public List<LowStockResult> getLowStockBooks(int threshold) {
        return repository.findAll()
                .stream()
                .map(stock -> {
                    Long bookId = stock.getBook() != null ? stock.getBook().getId() : null;
                    int quantity = bookId != null
                            ? stockMovementRepository.computeStockQuantity(bookId)
                            : 0;
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

    // ===== CREATE =====

    public Stock create(Stock stock) {
        JBook book = bookRepository.findById(stock.getBookId())
                .orElseThrow(() -> new NotFoundException("Book #" + stock.getBookId() + " not found"));

        // Vérifie qu'un stock n'existe pas déjà pour ce livre
        repository.findByBookId(stock.getBookId()).ifPresent(existing -> {
            throw new IllegalStateException("Stock already exists for Book #" + stock.getBookId());
        });

        JStock entity = JStock.builder()
                .alertThreshold(stock.getAlertThreshold())
                .location(stock.getLocation())
                .lastUpdated(LocalDateTime.now())
                .book(book)
                .build();

        return toStockWithComputedQuantity(repository.save(entity));
    }

    // ===== UPDATE (location et alertThreshold uniquement, jamais la quantity) =====

    public Stock update(Long id, Stock stock) {
        JStock entity = repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Stock #" + id + " not found"));

        if (stock.getLocation() != null) {
            entity.setLocation(stock.getLocation());
        }
        if (stock.getAlertThreshold() != null) {
            entity.setAlertThreshold(stock.getAlertThreshold());
        }
        entity.setLastUpdated(LocalDateTime.now());

        return toStockWithComputedQuantity(repository.save(entity));
    }

    // ===== Helper =====

    private Stock toStockWithComputedQuantity(JStock stock) {
        Long bookId = stock.getBook() != null ? stock.getBook().getId() : null;
        int computedQuantity = bookId != null
                ? stockMovementRepository.computeStockQuantity(bookId)
                : 0;
        return Stock.from(stock, computedQuantity);
    }
}
