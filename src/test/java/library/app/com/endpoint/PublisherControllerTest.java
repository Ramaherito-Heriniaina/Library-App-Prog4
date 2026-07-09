package library.app.com.endpoint;

import library.app.com.endpoint.rest.controller.health.PublisherController;
import library.app.com.service.PublisherService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PublisherController.class)
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherService publisherService;

    @Test
    void should_get_all_publishers() throws Exception {
        mockMvc.perform(get("/publishers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}