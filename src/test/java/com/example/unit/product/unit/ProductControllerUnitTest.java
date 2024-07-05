package com.example.unit.product.unit;

import com.example.unit.FilterRequest;
import com.example.unit.Product;
import com.example.unit.ProductController;
import com.example.unit.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductControllerUnitTest {
    @MockBean
    private ProductService productService;
    @InjectMocks
    private ProductController productController;
    @Test
    void filter(){
        Product firstTestProduct = new Product(1L,"test1","123",2500L,3);
        FilterRequest request = new FilterRequest("","123",null,0);
        when(productService.filterProduct(request)).thenReturn(List.of(firstTestProduct));
        ResponseEntity<List<Product>> response = productController.filter(request);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(List.of(firstTestProduct),response.getBody());
    }

    @Test
    void getByName(){
      Product product =  new Product(1L,"test","",2500L,3);
      when(productService.findByName("test")).thenReturn(product);
      ResponseEntity<Product> response = productController.getByName("test");
      assertEquals(HttpStatus.OK,response.getStatusCode());
      assertEquals(product,response.getBody());
    }

    @Test
    void getAll() {
        List<Product> products = Arrays.asList(new Product(1L,"test1","",2500L,3),
                new Product(2L,"test2","",3500L,3));
        when(productService.getAll()).thenReturn(products);
        ResponseEntity<List<Product>> response = productController.getAll();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(products, response.getBody());
    }

    @Test
    void getById() {
        Product product = new Product();
        product.setId(1L);
        when(productService.getById(1L)).thenReturn(product);
        ResponseEntity<Product> response = productController.getById(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(product, response.getBody());
    }

    @Test
    void save(){
        Product product =  new Product(1L,"test1","",2500L,3);
        when(productService.save(product)).thenReturn(product);
        ResponseEntity<Product> response = productController.save(product);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(product,response.getBody());
    }

    @Test
    void delete(){
        Product product = new Product();
        product.setId(1L);
        when(productService.delete(1L)).thenReturn(1L);
        ResponseEntity<Long> response = productController.delete(1L);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(1L,response.getBody());
    }

    @Test
    void update(){
        Product product =  new Product(1L,"test","",2500L,3);
        when(productService.update(1L,product)).thenReturn(product);
        ResponseEntity<Product> response = productController.update(1L,product);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertEquals(product,response.getBody());
        verify(productService).update(1L,product);
    }
}
