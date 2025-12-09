package com.codewithmosh.store.controller;

import com.codewithmosh.store.dto.ProductDto;
import com.codewithmosh.store.entities.Category;
import com.codewithmosh.store.entities.Product;
import com.codewithmosh.store.mappers.ProductMapper;
import com.codewithmosh.store.repositories.CategoryRepository;
import com.codewithmosh.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;
    private ProductMapper productMapper;
    private final CategoryRepository categoryRepository;

    @GetMapping
    public List<ProductDto> getAllProducts(
            @RequestHeader(required = false, name = "x-auth-token") String authToken,
            @RequestParam(name = "categoryId", required = false) Byte categoryId
    ) {
        System.out.println("Auth Token " + authToken);

        List<Product> products;
        if (categoryId != null) {
            products = productRepository.findByCategoryId(categoryId);
            System.out.println("Category Id");
        }
        else {
            products = productRepository.findAllCategory();
            System.out.println("All Category");
        }

        return products.stream().map(productMapper::toDto).toList();
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(
            @RequestBody ProductDto request,
            UriComponentsBuilder uriBuilder) {
        Category category = categoryRepository.findById(request.getCategoryId()).orElse(null);
        if (category == null)
            return ResponseEntity.badRequest().build();

        Product product = productMapper.toEntity(request);
        product.setCategory(category);
        productRepository.save(product);

        ProductDto productDto = productMapper.toDto(product);
        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();

        return ResponseEntity.created(uri).body(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateProduct(
            @PathVariable Long id,
            @RequestBody ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategoryId()).orElse(null);
        if (category == null)
            ResponseEntity.notFound().build();

        Product product = productRepository.findById(id).orElse(null);

        if (product == null)
            return ResponseEntity.notFound().build();

        productMapper.update(productDto, product);
        product.setCategory(category);
        productRepository.save(product);
        productDto.setId(id);

        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null)
            return ResponseEntity.notFound().build();

        productRepository.delete(product);
        return ResponseEntity.noContent().build();
    }

}

