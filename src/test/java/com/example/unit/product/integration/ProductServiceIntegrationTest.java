package com.example.unit.product.integration;

import com.example.unit.FilterRequest;
import com.example.unit.Product;
import com.example.unit.ProductRepository;
import com.example.unit.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceIntegrationTest {
    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void save() {
        Product savedProduct = service.save(new Product("first", "123", 2500L, 3));
        Optional<Product> product = repository.findById(savedProduct.getId());
        assertTrue(product.isPresent());
        assertEquals("first", savedProduct.getName());
        assertEquals(2500L, savedProduct.getPrice());
        assertEquals(3, savedProduct.getRank());
    }
    @Test
    void getProductById() {
        Product savedProduct = repository.save(new Product("first", "123", 2500L, 3));
        Product product = service.getById(savedProduct.getId());
        assertEquals(product.getName(), savedProduct.getName());
        assertEquals(product.getPrice(), savedProduct.getPrice());
        assertEquals(product.getRank(), savedProduct.getRank());
    }
    @Test
    void getByName() {
        Product savedProduct = repository.save(new Product("first", "123", 2500L, 3));
        Product product = service.findByName("first");
        assertEquals(savedProduct.getId(), product.getId());
        assertEquals("first", savedProduct.getName());
        assertEquals(2500L, savedProduct.getPrice());
        assertEquals(3, savedProduct.getRank());
    }
    @Test
    void updateProduct() {
        Product product = repository.save(new Product("first", "123", 2500L, 3));
        product.setRank(4);
        product.setCode("456");
        Product updated = service.update(product.getId(), product);
        assertEquals("456", updated.getCode());
        assertEquals(4, updated.getRank());
        assertEquals(2500L, updated.getPrice());
    }
    @Test
    void filterProducts() {
        repository.save(new Product("first", "123", 2500L, 3));
        repository.save(new Product("second", "456", 3500L, 4));
        FilterRequest request = new FilterRequest("second","",0L,0);
        List<Product> products = service.filterProduct(request);
        assertFalse(products.isEmpty());
        assertEquals(3500L,products.get(0).getPrice());
        assertEquals("456",products.get(0).getCode());
        assertEquals("second",products.get(0).getName());
        assertEquals(4,products.get(0).getRank());
    }
    @Test
    void deleteProduct() {
        Product product = repository.save(new Product("first", "123", 2500L, 3));
        Long id = service.delete(product.getId());
        Optional<Product> deleted = repository.findById(product.getId());
        assertEquals(id, product.getId());
        assertFalse(deleted.isPresent());
    }

}
