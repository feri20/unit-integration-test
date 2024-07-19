package com.example.unit;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository repository;

    public List<Product> filterProduct(FilterRequest request) {
        Specification<Product> spec = Specification.where(ProductSpecification.hasPrice(request.getPrice())
                .and(ProductSpecification.hasName(request.getName()))
                .and(ProductSpecification.hasCode(request.getCode()))
                .and(ProductSpecification.hasRank(request.getRank())));

        return repository.findAll(spec);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(Long id) {
        Optional<Product> product = repository.findById(id);
        return product.orElseThrow(() -> new EntityNotFoundException("there is no product with provided id"));

    }

    public Product getByCode(String code) {
        Optional<Product> product = repository.findByCode(code);
        return product.orElse(null);

    }

    public Product save(Product product) {
        try {
            return repository.save(product);
        } catch (DataIntegrityViolationException exception) {
            throw new DataIntegrityViolationException("this product already defined: " + product.getName());
        }
    }

    public Product update(Long id, Product product) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            Product targetProduct = optionalProduct.get();
            targetProduct.setCode(product.getCode());
            targetProduct.setName(product.getName());
            targetProduct.setPrice(product.getPrice());
            targetProduct.setRank(product.getRank());
            repository.save(targetProduct);
            return targetProduct;
        } else {
            throw new EntityNotFoundException("product not found with id :" + id);
        }
    }

    public Product findByName(String name) {
        Optional<Product> product = repository.findByName(name);
        return product.orElseThrow(() -> new EntityNotFoundException("there is no product with this name"));
    }

    public Long delete(Long id) {
        Product product = repository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("the product you are trying to delete does not exist"));
        repository.delete(product);
        return id;
    }

}
