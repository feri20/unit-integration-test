package com.example.unit.product;

import com.example.unit.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
class ProductTest {

    @Test
    void ShowPrice(){
        Product product = new Product();
        Long expectedPrice = 100L;
        product.setPrice(expectedPrice);
        Long actualPrice = product.showPrice();
        assertEquals(expectedPrice, actualPrice, "Price should match");
    }

    @Test
    void getId() {
        Product product = new Product();
        Long id = 123L;
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    void getName() {
        Product product = new Product();
        String name = "test";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    void getCode() {
        Product product = new Product();
        String code = "156";
        product.setCode(code);
        assertEquals(code, product.getCode());
    }

    @Test
    void getPrice() {
        Product product = new Product();
        Long price = 2500L;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void getRank() {
        Product product = new Product();
        int rank = 12;
        product.setRank(rank);
        assertEquals(rank, product.getRank());
    }

    @Test
    void setId() {
        Product product = new Product();
        Long id = 123L;
        product.setId(id);
        assertEquals(id, product.getId());
    }

    @Test
    void setName() {
        Product product = new Product();
        String name = "test";
        product.setName(name);
        assertEquals(name, product.getName());
    }

    @Test
    void setCode() {
        Product product = new Product();
        String code = "156";
        product.setCode(code);
        assertEquals(code, product.getCode());
    }

    @Test
    void setPrice() {
        Product product = new Product();
        Long price = 2500L;
        product.setPrice(price);
        assertEquals(price, product.getPrice());
    }

    @Test
    void setRank() {
        Product product = new Product();
        int rank = 12;
        product.setRank(rank);
        assertEquals(rank, product.getRank());
    }
}