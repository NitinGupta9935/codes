package com.codewithmosh.store.controller;

import com.codewithmosh.store.dto.UserDto;
import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.entities.User;
import com.codewithmosh.store.mappers.UserMapper;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;
import com.codewithmosh.store.repositories.UserRepository;
import com.codewithmosh.store.service.CategoryService;
import com.codewithmosh.store.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

//@Controller
@AllArgsConstructor
@RestController
public class HomeController {

    UserRepository userRepository;
    UserMapper userMapper;
    ProductService productService;
    CategoryService categoryService;

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "Nitin");

        return "index";
    }



    public List<Product> getAllProducts(@RequestParam(required = false, defaultValue = "", name = "sortBy") String sortBy) {
        if (Set.of("name", "email").contains(sortBy))
            sortBy = "email";

        List<Product> products = productRepository.findAll(Sort.by(sortBy));
        return products;
    }

}
