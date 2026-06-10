package library.app.com.service;

import com.librairie.dto.PublisherDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PublisherService {

    private final PublisherRepository publisherRepository;

    public List<Publisher> findAll() {
        return publisherRepository.findAll();
    }

    public Publisher findById(Long id) {
        return publisherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publisher not found with id: " + id));
    }

    public static PublisherDTO toDTO(Publisher publisher) {
        return PublisherDTO.builder()
                .id(publisher.getId())
                .name(publisher.getName())
                .email(publisher.getEmail())
                .phone(publisher.getPhone())
                .build();
    }

    public List<PublisherDTO> findAllDTO() {
        return findAll().stream().map(PublisherService::toDTO).collect(Collectors.toList());
    }

    public PublisherDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
