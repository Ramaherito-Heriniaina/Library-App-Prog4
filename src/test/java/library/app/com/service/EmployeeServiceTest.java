package library.app.com.service;


import library.app.com.endpoint.rest.model.JEmployee;
import library.app.com.entity.Employee;
import library.app.com.exception.NotFoundException;
import library.app.com.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repository;

    @InjectMocks
    private EmployeeService employeeService;

    @Test
    void getAll_ShouldReturnList() {
        JEmployee jEmployee = new JEmployee();
        Page<JEmployee> page = new PageImpl<>(List.of(jEmployee));
        doReturn(page).when(repository).findAll(any(Pageable.class));

        List<Employee> result = employeeService.getAll(0, 10);

        assertEquals(1, result.size());
        verify(repository).findAll(any(Pageable.class));
    }

    @Test
    void getById_ShouldReturnEmployee_WhenExists() {
        Long id = 1L;
        JEmployee jEmployee = new JEmployee();
        doReturn(Optional.of(jEmployee)).when(repository).findById(id);

        Employee result = employeeService.getById(id);

        assertNotNull(result);
    }

    @Test
    void getById_ShouldThrowNotFoundException_WhenDoesNotExist() {
        Long id = 1L;
        doReturn(Optional.empty()).when(repository).findById(id);

        assertThrows(NotFoundException.class, () -> employeeService.getById(id));
    }
}