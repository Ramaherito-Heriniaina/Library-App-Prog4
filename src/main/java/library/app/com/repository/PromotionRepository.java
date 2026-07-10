package library.app.com.repository;

import library.app.com.endpoint.rest.model.JPromotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionRepository extends JpaRepository<JPromotion, Long> {}
