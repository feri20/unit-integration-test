package com.example.unit.relations.service;

import com.example.unit.relations.ParentEntity;
import com.example.unit.relations.repository.ParentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    private ParentRepository repository;

//
//    public List<ParentEntity> filterProduct(FilterRequest request) {
//        Specification<Product> spec = Specification.where(ProductSpecification.hasPrice(request.getPrice())
//                .and(ProductSpecification.hasName(request.getName()))
//                .and(ProductSpecification.hasCode(request.getCode()))
//                .and(ProductSpecification.hasRank(request.getRank())));
//        return repository.findAll(spec);
//    }

    public List<ParentEntity> getAll() {
        return repository.findAll();
    }

    public ParentEntity getById(Long id) {
        return repository.getReferenceById(id);
    }

    public void save(ParentEntity parentEntity) {
        repository.save(parentEntity);
    }


    public ParentEntity update(Long id, ParentEntity parent) {
        Optional<ParentEntity> optionalProduct = repository.findById(id);
        if (optionalProduct.isPresent()) {
            ParentEntity targetParent = optionalProduct.get();
            targetParent.setCode(parent.getCode());
            targetParent.setName(parent.getName());
            return targetParent;
        } else {
            throw new EntityNotFoundException("product not found" + id);
        }
    }

    public ParentEntity findByName(String name) {
        Optional<ParentEntity> parent = repository.findByName(name);
        return parent.orElseThrow(()->new EntityNotFoundException("there is no parent with this name"));
    }
}
