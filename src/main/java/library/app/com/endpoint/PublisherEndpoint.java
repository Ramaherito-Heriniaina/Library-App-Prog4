package library.app.com.endpoint;


import library.app.com.repository.model.Publisher;
import library.app.com.service.PublisherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherEndpoint {

    private final PublisherService service;

    public PublisherEndpoint(PublisherService service) {this.service = service;}

    @GetMapping
    public List<Publisher> getAll() {return service.getAllPublishers();}

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {service.deletePublisher(String.valueOf(id));}
}