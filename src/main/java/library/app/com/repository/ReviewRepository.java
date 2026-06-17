package library.app.com.repository;

import library.app.com.repository.model.Review;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ReviewRepository {

    private final List<Review> Reviews = new ArrayList<>();

    public List<Review> findAll() {
        return Reviews;
    }

    public void deleteById(Long id) {
        Reviews.removeIf(Review -> Review.getId().equals(id));
    }
}