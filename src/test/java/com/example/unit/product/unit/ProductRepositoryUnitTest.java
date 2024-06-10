package com.example.unit.product.unit;

import com.example.unit.Product;
import com.example.unit.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
class ProductRepositoryUnitTest {

    @Autowired
    public ProductRepository repository;

    @BeforeEach
    void setUp() {
        Product product = new Product("test Product", "123", 10L, 1);
        repository.save(product);
    }

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void findByName(){
        Optional<Product> retrievedProduct = repository.findByName("test Product");
        assertTrue(retrievedProduct.isPresent());
        assertEquals("123",retrievedProduct.get().getCode());
        assertEquals(1,retrievedProduct.get().getRank());
    }

    @Test
    void findByCode(){
        Optional<Product> retrievedProduct = repository.findByName("test Product");
        assertTrue(retrievedProduct.isPresent());
        assertEquals("test Product",retrievedProduct.get().getName());
        assertEquals(1,retrievedProduct.get().getRank());
    }


}
