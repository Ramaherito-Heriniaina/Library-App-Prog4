package library.app.com.endpoint;

import library.app.com.endpoint.rest.controller.health.SupplierController;
import library.app.com.service.SupplierService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SupplierController.class)
public class SupplierControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SupplierService supplierService;

    @Test
    void should_get_all_suppliers() throws Exception {
        mockMvc.perform(get("/suppliers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}