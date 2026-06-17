package library.app.com.repository;

import library.app.com.repository.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PublisherRepository {

    private final List<Publisher> Publishers = new ArrayList<>();

    public List<Publisher> findAll() {
        return Publishers;
    }

    public void deleteById(Long id) { Publishers.removeIf(Publisher -> Publisher.getId().equals(id)); }
}