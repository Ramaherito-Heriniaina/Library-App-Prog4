package library.app.com.repository;

import library.app.com.endpoint.rest.model.JStockMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockMovementRepository extends JpaRepository<JStockMovement, Long> {

    List<JStockMovement> findByBookId(Long bookId);

    /**
     * Calcule la quantité en stock pour un livre :
     * somme des IN moins somme des OUT.
     * COALESCE garantit 0 si aucun mouvement n'existe (au lieu de null).
     */
    @Query("""
        SELECT COALESCE(SUM(
            CASE WHEN m.type = 'IN' THEN m.quantity
                 WHEN m.type = 'OUT' THEN -m.quantity
                 ELSE 0 END
        ), 0)
        FROM JStockMovement m
        WHERE m.book.id = :bookId
        """)
    Integer computeStockQuantity(@Param("bookId") Long bookId);
}
