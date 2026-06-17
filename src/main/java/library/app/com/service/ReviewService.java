package library.app.com.service;


import library.app.com.repository.model.Review;
import library.app.com.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository repository;

    public ReviewService(ReviewRepository repository) {
        this.repository = repository;
    }

    public List<Review> getAllReviews() {
        return repository.findAll();
    }

    public void deleteReview(String id) {
        repository.deleteById(Long.valueOf(id));
    }
}