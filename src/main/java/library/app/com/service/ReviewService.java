package library.app.com.service;

import library.app.com.entity.Review;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository repository;

    public List<Review> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Review::from)
                .toList();
    }

    public Review getById(Long id) {
        return repository.findById(id)
                .map(Review::from)
                .orElseThrow(() -> new NotFoundException("Review #" + id + " not found"));
    }

    public Review createOrUpdate(Review review) {
        return Review.from(repository.save(review));
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Review #" + id + " not found");
        }
        repository.deleteById(id);
    }
}