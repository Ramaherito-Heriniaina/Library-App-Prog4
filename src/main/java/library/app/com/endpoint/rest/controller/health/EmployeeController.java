package library.app.com.endpoint.rest.controller.health;

import java.util.List;
import library.app.com.entity.Employee;
import library.app.com.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {

  private final EmployeeService service;

  @GetMapping
  public List<Employee> getAll(
      @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "20") int pageSize) {
    return service.getAll(page, pageSize);
  }

  @GetMapping("/{id}")
  public Employee getById(@PathVariable Long id) {
    return service.getById(id);
  }
}
