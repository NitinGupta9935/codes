package com.example.OrderService.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class Controller {
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getOrder(@PathVariable String id) {
        HttpURLConnection httpURLConnection = null;

        try {
            String url = "http://localhost:8082/products/" + id;

            URL obj = new URL(url);
            httpURLConnection = (HttpURLConnection) obj.openConnection();

            // Setting http request method and header
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept", "application/json");

            // max time to establish TCP connection, timeout in millisecond
            httpURLConnection.setConnectTimeout(100);
            // max time to wait for server response after connection is established, timeout in millisecond
            httpURLConnection.setReadTimeout(500);

            // Opens the TCP connection trigger the http request and Read response
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            StringBuilder response = new StringBuilder();
            String responseLine;
            while ((responseLine = in.readLine()) != null) 
                response.append(responseLine);

            in.close();
            System.out.println("Response: " + response.toString());

        }
        catch (Exception e) {
            // exception handling here
        }
        finally {
            if (httpURLConnection != null) {
                httpURLConnection.disconnect();
            }
        }

        return ResponseEntity.ok("order call successful");
    }
}
