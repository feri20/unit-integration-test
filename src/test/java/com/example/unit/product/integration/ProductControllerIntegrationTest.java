package com.example.unit.product.integration;

import com.example.unit.FilterRequest;
import com.example.unit.Product;
import com.example.unit.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductRepository repository;
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp(){
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        repository.save(firstTestProduct);
    }
    @AfterEach
    void tearDown(){
        repository.deleteAll();
    }

    @Test
    void save() throws Exception {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        String json = objectMapper.writeValueAsString(firstTestProduct);
        mockMvc.perform(post("/api")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("first"))
                .andExpect(jsonPath("$.price").value(2500L));

    }

    @Test
    void getById() throws Exception {
        mockMvc.perform(get("/api/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("first"))
                .andExpect(jsonPath("$.price").value(2500L));

    }

    @Test
    void getAll() throws Exception {
        Product secondTestProduct =  new Product(2L,"second","345",3500L,3);
        repository.save(secondTestProduct);
        mockMvc.perform(get("/api").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$.[0].id").value(1L))
                .andExpect(jsonPath("$.[0].name").value("first"))
                .andExpect(jsonPath("$.[0].code").value("123"))
                .andExpect(jsonPath("$.[0].price").value(2500L))
                .andExpect(jsonPath("$.[0].rank").value(2))
                .andExpect(jsonPath("$.[1].id").value(2L))
                .andExpect(jsonPath("$.[1].name").value("second"))
                .andExpect(jsonPath("$.[1].code").value("345"))
                .andExpect(jsonPath("$.[1].price").value(3500L))
                .andExpect(jsonPath("$.[1].rank").value(3));

    }


    @Test
    void getByName() throws Exception {
        mockMvc.perform(get("/api/by-name").param("name","first")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.rank").value(2))
                .andExpect(jsonPath("$.price").value(2500L));
    }

    @Test
    void filter() throws Exception {
        repository.save(new Product(2L,"second","345",3500L,3));
        FilterRequest request =  new FilterRequest("first","123",0L,0);
        String json = objectMapper.writeValueAsString(request);
        mockMvc.perform(get("/api/filter")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.[0].id").value(1L))
               .andExpect(jsonPath("$.[0].name").value("first"))
               .andExpect(jsonPath("$.[0].code").value("123"))
               .andExpect(jsonPath("$.[0].price").value(2500L))
               .andExpect(jsonPath("$.[0].rank").value(2));

    }

    @Test
    void update() throws Exception {
        Product updated = new Product("first-test","123",2200L,2);
        mockMvc.perform(put("/api/1").contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(updated)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("first-test"))
                .andExpect(jsonPath("$.price").value(2200L))
                .andExpect(jsonPath("$.rank").value(2))
                .andExpect(jsonPath("$.id").value(1L));

    }

    @Test
    void deleteProduct() throws Exception {
        mockMvc.perform(delete("/api/1").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("1"));
        boolean exist = repository.existsById(1L);
        assertFalse(exist);
    }
}
