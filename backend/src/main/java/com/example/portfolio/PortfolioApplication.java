package com.example.portfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PortfolioApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortfolioApplication.class, args);
    }
}

@RestController
class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hello from Spring Boot Backend!";
    }

    @GetMapping("/api/greeting")
    public Message greet() {
        return new Message("Hello, this is a greeting from the Spring Boot API!");
    }
}

record Message(String content) {}
