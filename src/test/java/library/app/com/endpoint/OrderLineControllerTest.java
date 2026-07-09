package library.app.com.endpoint;

import library.app.com.endpoint.rest.controller.health.OrderLineController;
import library.app.com.service.OrderLineService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OrderLineController.class)
public class OrderLineControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderLineService orderLineService;

    @Test
    void should_get_all_order_lines() throws Exception {
        mockMvc.perform(get("/order-lines")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}