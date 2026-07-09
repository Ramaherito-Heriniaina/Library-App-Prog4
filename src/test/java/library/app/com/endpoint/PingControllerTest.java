package library.app.com.endpoint;

import library.app.com.endpoint.rest.controller.health.PingController;
import library.app.com.repository.DummyRepository;
import library.app.com.repository.DummyUuidRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PingController.class)
public class PingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DummyRepository dummyRepository;

    @MockBean
    private DummyUuidRepository dummyUuidRepository;

    @Test
    void should_ping() throws Exception {
        mockMvc.perform(get("/ping")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}