package com.example.store.services;

import com.example.store.entities.Category;
import com.example.store.entities.Product;
import com.example.store.repository.CategoryRepository;
import com.example.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public void addProduct(Product product) {
        Product p = productRepository.save(product);
        System.out.println(p);
    }

    @Transactional
    public void addNewProduct() {
        Iterable<Category> iterable = categoryRepository.findAll();

        Category category = iterable.iterator().next();
        System.out.println(category.getProducts());

        Product product = Product.builder()
                .name("product 3 ")
                .price(9935)
                .category(category)
                .build();

        System.out.println(product);

        category.getProducts().add(product);
        category = categoryRepository.save(category);
        System.out.println(category);
    }

    public void removeProduct(long id) {
        productRepository.deleteById(id);
    }
}
