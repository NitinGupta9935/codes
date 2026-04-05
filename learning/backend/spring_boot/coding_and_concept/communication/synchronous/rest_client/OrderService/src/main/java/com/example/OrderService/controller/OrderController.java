package com.example.OrderService.controller;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {
    
    @Autowired
    RestClient restClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable String id) {
        
        String response = restClient
            .get()
            .uri("http://localhost:8082/products/" + id)
            .retrieve()
            .body(String.class);

        System.out.println("Response from Product API called from order service: " + response);
        return ResponseEntity.ok("order call successful");
    }

    // GET Method Example
    public void tempGet(String id) {
        String response = restClient
            .get()
            .uri("http://localhost:8082/products/" + id)
            .accept(MediaType.APPLICATION_JSON)
            .header("X-Custom-Header", "xyz")
            .retrieve()
            .body(String.class);

    }

    // POST Method Example
    public void tempPost() {
        ResponseEntity<String> response = restClient
        .post()
        .uri("http://localhost:8082/products/create")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .body("{\"name\":\"Laptop\",\"price\":50000}")
        .retrieve()
        .toEntity(String.class);

        String responseBody = response.getBody();
    }

    // Delete Method Example
    public void tempDelete(String id) {
        ResponseEntity<Void> response = restClient
        .delete()
        .uri("http://localhost:8082/products/" + id)
        .retrieve()
        .toBodilessEntity();

        HttpStatusCode deletionStatus = response.getStatusCode();
    }

    // Exception Handling Example
    public void exceptionHandling() {
        String id = "1";
        
        // GET API
        String response = restClient
        .get()
        .uri("http://localhost:8082/products/" + id)
        .retrieve()
        .onStatus(
            status -> status.is4xxClientError(),
            (request, response1) -> {
                throw new IllegalArgumentException("Invalid product ID");
            }
        )
        .onStatus(
            status -> status.is5xxServerError(),
            (request, response1) -> {
                throw new RuntimeException("Something wrong at server");
            }
        )
        .body(String.class);
    }

    // Full control over Response Building and Exception Handling
    public void fullControl() {
        String id = "1";
        
        // GET API
        String response = restClient
        .get()
        .uri("http://localhost:8082/products/{id}", id)
        .exchange((request, response1) -> {
            if (response1.getStatusCode().is4xxClientError()) {
                throw new IllegalStateException("Client error: Invalid product ID");
            } else if (response1.getStatusCode().is5xxServerError()) {
                throw new RuntimeException("Server error occurred");
            } else {
                return StreamUtils.copyToString(
                        response1.getBody(),
                        StandardCharsets.UTF_8
                );
            }
        });
    }
}
