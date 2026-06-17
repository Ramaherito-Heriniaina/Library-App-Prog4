package library.app.com.repository;

import library.app.com.repository.model.Fine;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FineRepository {

    private final List<Fine> fines = new ArrayList<>();

    public List<Fine> findAll() {
        return fines;
    }

    public void deleteById(Long id) {
        fines.removeIf(fine -> fine.getId().equals(id));
    }
}