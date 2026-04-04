package com.example.ProductService.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class Controller {

    @GetMapping("/{id}")
    public String getProduct(@PathVariable String id) {
        System.out.println("API HIT");
        return "Product fetched with id: " + id;
    }
}
