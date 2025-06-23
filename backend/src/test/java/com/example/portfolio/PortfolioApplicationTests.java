package com.example.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.Matchers.containsString;


@SpringBootTest
@AutoConfigureMockMvc
class PortfolioApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void contextLoads() {
        // Basic test to ensure the application context loads
    }

    @Test
    void homeEndpointShouldReturnGreeting() throws Exception {
        this.mockMvc.perform(get("/"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello from Spring Boot Backend!")));
    }

    @Test
    void apiGreetingEndpointShouldReturnMessage() throws Exception {
        this.mockMvc.perform(get("/api/greeting"))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"content\":\"Hello, this is a greeting from the Spring Boot API!\"}"));
    }
}
