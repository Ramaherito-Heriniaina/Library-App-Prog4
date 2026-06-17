package library.app.com.endpoint;


import library.app.com.repository.model.Review;
import library.app.com.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewEndpoint {

    private final ReviewService service;

    public ReviewEndpoint(ReviewService service) {this.service = service;}

    @GetMapping
    public List<Review> getAll() {return service.getAllReviews();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deleteReview(String.valueOf(id));}
}