package library.app.com.repository;

import library.app.com.endpoint.rest.model.JSale;
import library.app.com.entity.Sale;
import library.app.com.repository.projection.RevenueByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<JSale, Long> {
    @Query("""
        SELECT
            c.name AS category,
            SUM(si.quantity * si.unitPrice) AS revenue
        FROM JSaleItem si
        JOIN si.book b
        JOIN b.categories c
        GROUP BY c.name
        ORDER BY c.name
    """)
    List<RevenueByCategory> getRevenueByCategory();
}
