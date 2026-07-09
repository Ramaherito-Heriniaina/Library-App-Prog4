package library.app.com.endpoint;

import library.app.com.endpoint.rest.controller.health.StockController;
import library.app.com.service.StockService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(StockController.class)
public class StockControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StockService stockService;

    @Test
    void should_get_all_stocks() throws Exception {
        mockMvc.perform(get("/stocks")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}