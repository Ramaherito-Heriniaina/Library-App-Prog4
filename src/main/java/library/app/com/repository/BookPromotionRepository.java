package library.app.com.repository;

import library.app.com.repository.model.BookPromotion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookPromotionRepository {

    private final List<BookPromotion> bookCopies = new ArrayList<>();

    public List<BookPromotion> findAll() {
        return bookCopies;
    }

    public void deleteById(Long id) {
        bookCopies.removeIf(BookPromotion -> BookPromotion.getId().equals(id));
    }
}