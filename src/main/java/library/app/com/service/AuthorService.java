package library.app.com.service;

import com.librairie.dto.AuthorDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    public Author findById(Long id) {
        return authorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Author not found with id: " + id));
    }

    public List<Author> findByLastName(String lastName) {
        return authorRepository.findByLastNameContainingIgnoreCase(lastName);
    }

    public static AuthorDTO toDTO(Author author) {
        return AuthorDTO.builder()
                .id(author.getId())
                .firstName(author.getFirstName())
                .lastName(author.getLastName())
                .nationality(author.getNationality())
                .build();
    }

    public List<AuthorDTO> findAllDTO() {
        return findAll().stream().map(AuthorService::toDTO).collect(Collectors.toList());
    }

    public AuthorDTO findByIdDTO(Long id) {
        return toDTO(findById(id));
    }
}
