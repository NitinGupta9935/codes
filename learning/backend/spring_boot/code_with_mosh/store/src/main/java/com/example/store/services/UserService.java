package com.example.store.services;

import com.example.store.dtos.ProductSummary;
import com.example.store.dtos.ProductSummaryDTO;
import com.example.store.dtos.UserSummary;
import com.example.store.entities.Address;
import com.example.store.entities.Category;
import com.example.store.entities.Product;
import com.example.store.entities.User;
import com.example.store.repository.ProductRepository;
import com.example.store.repository.UserRepository;
import com.example.store.repository.specifications.ProductSpec;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProductRepository productRepository;

    public void addUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void showEntityState() {
		User user = User.builder()
				.name("John")
				.password("password")
				.email("john@gamil.com")
				.build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    public void showRelatedEntities() {
        User user = userRepository.findById(3L).orElseThrow();
        System.out.println(user);
    }

    public void persistRelated() {
        User user = User.builder()
                .name("Jone Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        Address address = Address.builder()
                .street("street")
                .city("city")
                .state("state")
                .zip("zip")
                .build();

        user.addAddress(address);
        userRepository.save(user);
    }


    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(3L);

        User user = userRepository.findById(7L).orElseThrow();
        Address address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void addWishlist() {
        Iterable<Product> iterable = productRepository.findAll();
        User user = userRepository.findById(1L).orElseThrow();

        for (Product product: iterable) {
            user.getFavoriteProducts().add(product);
        }

        userRepository.save(user);
    }

//    @Transactional
//    public void updateProductPrices() {
//        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 1);
//    }

    public void fetchProducts() {
        var products = productRepository.findByCategory3(new Category((byte) 2));
        System.out.println(products.size());
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchProductsUsingStoredProcedure() {
        var products = productRepository.findProducts(BigDecimal.valueOf(1),BigDecimal.valueOf(100));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUser() {
        User user = userRepository.findByEmail("user1@gmail.com").orElseThrow();
        System.out.println(user.getId());
        System.out.println(user);
    }

//    4.10.1
    @Transactional
    public void fetchProductWithExampleObject() {
        Product product = new Product();
        product.setName("product");

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Product> example = Example.of(product, matcher);
        List<Product> products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }

    public void fetchSortedProducts() {
//        Sort.by("name", "price").descending();

        Sort sort = Sort.by("name").and(
            Sort.by("price").descending()
        );

        productRepository.findAll(sort).forEach(System.out::println);
    }

    public void fetchPaginatedProducts(int pageNumber, int size) {
        PageRequest pageRequest = PageRequest.of(pageNumber, size);
        Page<Product> page = productRepository.findAll(pageRequest);

        List<Product> products = page.getContent();
        products.forEach(System.out::println);

        int totalPages = page.getTotalPages();
        long totalElements = page.getTotalElements();
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Total Elements: " + totalElements);
    }

    public void fetchProductsBySpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice) {
        Specification<Product> spec = Specification.where(null);

        if (name != null) {
            spec = spec.and(ProductSpec.hasName(name));
        }

        if (minPrice != null) {
            spec = spec.and(ProductSpec.hasPriceGreaterThanOrEqualTo(minPrice));
        }

        if (maxPrice != null) {
            spec = spec.and(ProductSpec.hasPriceLessThanOrEqualTo(maxPrice));
        }

        productRepository.findAll(spec).forEach(System.out::println);

    }

    public void fetchProductsByCriteria() {
        List<Product> products = productRepository.findProductsByCriteria("prod", BigDecimal.valueOf(1), null);
        products.forEach(System.out::println);
    }

}
