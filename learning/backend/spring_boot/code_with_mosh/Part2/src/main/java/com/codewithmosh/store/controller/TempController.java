package com.codewithmosh.store.controller;

import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.UserRepository;
import com.codewithmosh.store.service.CategoryService;
import com.codewithmosh.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/temp")
public class TempController {

    UserRepository userRepository;
    UserMapper userMapper;
    ProductService productService;
    CategoryService categoryService;

    @GetMapping("/deleteAllCategory")
    public String deleteAllCategory() {
        categoryService.deleteAll();
        return "All Categories Deleted";
    }

    @GetMapping("/deleteAllProduct")
    public String deleteAllProducts() {
        productService.deleteAll();
        return "All Products Deleted";
    }

    @GetMapping("/add/product/{productId}/{categoryId}")
    public Product addProduct(@PathVariable int productId, @PathVariable int categoryId) {
        return productService.addProduct(productId, categoryId);
    }

    @GetMapping("/add/category/{categoryId}")
    public Category addCategory(@PathVariable int categoryId) {
        return categoryService.addCategory(categoryId);
    }

}
