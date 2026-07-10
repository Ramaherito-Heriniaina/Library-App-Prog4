package library.app.com.service;

import java.util.List;
import library.app.com.endpoint.rest.model.JBook;
import library.app.com.endpoint.rest.model.JStockMovement;
import library.app.com.entity.StockMovement;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.BookRepository;
import library.app.com.repository.StockMovementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StockMovementService {

  private final StockMovementRepository repository;
  private final BookRepository bookRepository;

  // ===== READ =====

  public List<StockMovement> getAll(int page, int pageSize) {
    return repository.findAll(PageRequest.of(page, pageSize)).stream()
        .map(StockMovement::from)
        .toList();
  }

  public StockMovement getById(Long id) {
    return repository
        .findById(id)
        .map(StockMovement::from)
        .orElseThrow(() -> new NotFoundException("StockMovement #" + id + " not found"));
  }

  public List<StockMovement> getByBookId(Long bookId) {
    return repository.findByBookId(bookId).stream().map(StockMovement::from).toList();
  }

  // ===== CREATE =====

  public StockMovement create(StockMovement movement) {
    JBook book =
        bookRepository
            .findById(movement.getBookId())
            .orElseThrow(
                () -> new NotFoundException("Book #" + movement.getBookId() + " not found"));

    JStockMovement entity =
        JStockMovement.builder()
            .type(movement.getType())
            .quantity(movement.getQuantity())
            .format(movement.getFormat())
            .movementDate(movement.getMovementDate())
            .note(movement.getNote())
            .book(book)
            .build();

    return StockMovement.from(repository.save(entity));
  }
}
