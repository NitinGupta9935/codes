package com.codewithmosh.store.service;

import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    public CategoryRepository categoryRepository;
    public ProductRepository productRepository;

    @Transactional
    public Product addProduct(int id, int categoryId) {
        Category category = categoryRepository.findById((byte) categoryId).orElse(null);

        if (category == null) {
            System.out.println("Category is null ");
            return null;
        }

        int num = (int) (Math.random() * 10000);

        Product product = Product.builder()
                .name("Product " + id)
                .price(BigDecimal.valueOf(num))
                .description("Description " + num)
                .category(category)
                .build();

        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

}
