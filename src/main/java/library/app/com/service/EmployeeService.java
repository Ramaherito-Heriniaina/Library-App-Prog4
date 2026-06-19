package library.app.com.service;

import library.app.com.entity.Employee;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getAll(int page, int pageSize) {
        return repository.findAll(PageRequest.of(page, pageSize))
                .stream()
                .map(Employee::from)
                .toList();
    }

    public Employee getById(Long id) {
        return repository.findById(id)
                .map(Employee::from)
                .orElseThrow(() -> new NotFoundException("Employee #" + id + " not found"));
    }
}
