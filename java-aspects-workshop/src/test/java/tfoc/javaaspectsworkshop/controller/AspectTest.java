package tfoc.javaaspectsworkshop.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class AspectTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAspectForCar() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/changeCar")
                        .contentType("application/json")
                        .content("{\"seats\": 4, \"brand\": \"Toyota\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"seats\": 2, \"brand\": \"AM\"}"));
    }

    @Test
    void testAspectForMoto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/changeMoto")
                        .contentType("application/json")
                        .content("{\"color\": \"Red\", \"brand\": \"Honda\"}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json("{\"color\": \"Red\", \"brand\": \"Honda\"}"));

    }
}
