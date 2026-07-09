package library.app.com.repository;

import java.util.List;
import library.app.com.endpoint.rest.model.JArrival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArrivalRepository extends JpaRepository<JArrival, Long> {

  List<JArrival> findByBookId(Long bookId);
}
