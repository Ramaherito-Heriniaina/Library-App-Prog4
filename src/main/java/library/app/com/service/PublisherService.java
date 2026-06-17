package library.app.com.service;


import library.app.com.repository.model.Publisher;
import library.app.com.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherService {

    private final PublisherRepository repository;

    public PublisherService(PublisherRepository repository) {
        this.repository = repository;
    }

    public List<Publisher> getAllPublishers() {
        return repository.findAll();
    }

    public void deletePublisher(String id) {
        repository.deleteById(Long.valueOf(id));
    }
}