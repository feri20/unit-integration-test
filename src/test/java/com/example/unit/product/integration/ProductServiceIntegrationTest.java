package com.example.unit.product.integration;

import com.example.unit.Product;
import com.example.unit.ProductRepository;
import com.example.unit.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProductServiceIntegrationTest {


    @Autowired
    private ProductService service;

    @Autowired
    private ProductRepository repository;


    @BeforeEach
    void setUp() {
        repository.save(new Product("first","123",2500L,3));
    }

    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    @Test
    void save(){

    }

}
