package library.app.com.endpoint.rest.controller.health;

import library.app.com.PojaGenerated;
import library.app.com.repository.DummyRepository;
import library.app.com.repository.DummyUuidRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@PojaGenerated
@RestController
@AllArgsConstructor
public class PingController {

  DummyRepository dummyRepository;
  DummyUuidRepository dummyUuidRepository;

  public static final ResponseEntity<String> OK = new ResponseEntity<>("OK", HttpStatus.OK);
  public static final ResponseEntity<String> KO =
      new ResponseEntity<>("KO", HttpStatus.INTERNAL_SERVER_ERROR);

  @GetMapping("/ping")
  public String ping() {
    return "pong";
  }

  @GetMapping("/ping/db")
  public ResponseEntity<String> pingDb() {
    try {
      dummyRepository.findAll();
      return OK;
    } catch (Exception e) {
      return KO;
    }
  }

}


