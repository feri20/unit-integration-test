package com.example.unit.product.integration;

import com.example.unit.Product;
import com.example.unit.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class ProductRepositoryIntegrationTest {

    @Autowired
    public ProductRepository repository;

    @BeforeEach
    void setUpData(){
        repository.save(new Product("first","123",2500L,3));

    }
    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    @Test
    void findByName(){
        Optional<Product> product = repository.findByName("first");
        assertTrue(product.isPresent());
        assertNotNull(product.get().getId());
        assertEquals("first",product.get().getName());
    }

    @Test
    void findByCode(){
        Optional<Product> product = repository.findByRank(3);
        assertTrue(product.isPresent());
        assertNotNull(product.get().getId());
        assertEquals("first",product.get().getName());
    }

}
