package com.example.store.repository;

import com.example.store.dtos.ProductSummary;
import com.example.store.dtos.ProductSummaryDTO;
import com.example.store.entities.Category;
import com.example.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCriteriaRepository, JpaSpecificationExecutor<Product> {

    /*

    // String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByEndingWith(String name);
    List<Product> findByEndingWithIgnoreCase(String name);

    // Numbers
    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

    // Null
    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    // Multiple conditions
    List<Product> findByDescriptionNullAndNameNull();

    // Sort (OrderBy)
    List<Product> findByNameOrderByPrice(String name);

    // Limit (Top/First)
    List<Product> findTop5NameOrderByPrice(String name);

    List<Product> findFirst5ByNameLikeOrderByPrice(String name);

    // Find products whose prices are in a given range and sort by name
    // SQL or JPQL
    @Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
    // nativeQuery = true // because by default the query annotation expect a JPQL query
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Query(value = "select count(*) from products p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    // For update scenarios we should always apply @Modifying to tell hibernate that this is update operation not select operation
    @Modifying
    @Query(value = "UPDATE Product SET price = :newPrice WHERE category_id = :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte CateoryId);

     */

    // Fetching partial data with projections
    List<ProductSummaryDTO> findByCategory(Category category);

    // use class with query
    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummary> findByCategory2(@Param("category") Category category);

    // use interface with query
    @Query("select new com.example.store.dtos.ProductSummaryDTO(p.id, p.name) from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory3(@Param("category") Category category);

    // Stored Procedure
    @Procedure("findProductsByPrice")
    List<Product> findProducts(BigDecimal min, BigDecimal max);

}
