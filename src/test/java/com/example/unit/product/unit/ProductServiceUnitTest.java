package com.example.unit.product.unit;

import com.example.unit.FilterRequest;
import com.example.unit.Product;
import com.example.unit.ProductRepository;
import com.example.unit.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceUnitTest {
    @MockBean
    private ProductRepository repository;
    @InjectMocks
    private ProductService productService;


    @Test
    void filterProduct() {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        FilterRequest request = new FilterRequest("first","",null,2);
        List<Product> expectedProducts = List.of(firstTestProduct);
        when(repository.findAll(ArgumentMatchers.<Specification<Product>>any())).thenReturn(expectedProducts);
        List<Product> result = productService.filterProduct(request);
        verify(repository, times(1)).findAll(ArgumentMatchers.<Specification<Product>>any());
        assertEquals(1, result.size());
        assertEquals(expectedProducts,result);

    }

    @Test
    void getAll() {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        Product second_test_product =  new Product(2L,"second","456",3500L,1);
        List<Product> products = List.of(firstTestProduct,second_test_product);
        when(repository.findAll()).thenReturn(products);
        List<Product> retrievedProducts =  productService.getAll();
        assertEquals(2,products.size());
        assertTrue(retrievedProducts.containsAll(products));
    }

    @Test
    void getById() {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        when(repository.getReferenceById(1L)).thenReturn(firstTestProduct);
        Product product = productService.getById(1L);
        assertNotNull(product);
        assertEquals(product,firstTestProduct);
    }

    @Test
    void save() {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        when(repository.save(any(Product.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));
        Product product = productService.save(firstTestProduct);
        assertEquals(firstTestProduct.getId(), product.getId());
        assertEquals(firstTestProduct.getName(), product.getName());
        assertEquals(firstTestProduct.getCode(), product.getCode());
        assertEquals(firstTestProduct.getPrice(), product.getPrice());
    }

    @Test
    void update() {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        when(repository.findById(1L)).thenReturn(Optional.of(firstTestProduct));
        productService.update(1L,new Product(1L,"first","456",3000L,2));
        verify(repository).save(firstTestProduct);
        assertEquals("456",firstTestProduct.getCode());
        assertEquals(3000L,firstTestProduct.getPrice());
    }

    @Test
    void findByName() {
        Product firstTestProduct =  new Product(1L,"first","123",2500L,2);
        when(repository.findByName("first")).thenReturn(Optional.of(firstTestProduct));
        Product product = productService.findByName("first");
        assertEquals(firstTestProduct.getId(), product.getId());
        assertEquals(firstTestProduct.getCode(), product.getCode());
        assertEquals(firstTestProduct.getPrice(), product.getPrice());
        assertEquals(firstTestProduct.getRank(), product.getRank());
    }

    @Test
    void delete() {
        Product firstTestProduct = new Product();
        firstTestProduct.setId(1L);
        when(repository.findById(1L)).thenReturn(Optional.of(firstTestProduct));
        productService.delete(1L);
        verify(repository).delete(firstTestProduct);
    }

}
