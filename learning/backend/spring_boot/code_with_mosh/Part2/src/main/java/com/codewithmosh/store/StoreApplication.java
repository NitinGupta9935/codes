package com.codewithmosh.store;

import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;
import com.codewithmosh.store.repositories.UserRepository;
import com.codewithmosh.store.service.CategoryService;
import com.codewithmosh.store.service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

    public static UserRepository userRepository;
    public static ProductService productService;
    public static CategoryService categoryService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        userRepository = context.getBean(UserRepository.class);
        productService = context.getBean(ProductService.class);
        categoryService = context.getBean(CategoryService.class);



    }

}
