package library.app.com.endpoint;

import library.app.com.endpoint.rest.controller.health.RestockingController;
import library.app.com.service.RestockingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RestockingController.class)
public class RestockingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestockingService restockingService;

    @Test
    void should_get_all_restockings() throws Exception {
        mockMvc.perform(get("/restockings")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}