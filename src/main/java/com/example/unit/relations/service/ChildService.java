package com.example.unit.relations.service;

import com.example.unit.relations.ChildEntity;
import com.example.unit.relations.repository.ChildRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ChildService {
    private final ChildRepository repository;
    private final ParentService service;

//    @Transactional(propagation = Propagation.MANDATORY,isolation = Isolation.SERIALIZABLE)
//    public List<ChildEntity> filterChildEntity(FilterRequest request) {
//        Specification<ChildEntity> spec = Specification.where(ChildEntitySpecification.hasPrice(request.getPrice())
//                .and(ChildEntitySpecification.hasName(request.getName()))
//                .and(ChildEntitySpecification.hasCode(request.getCode()))
//                .and(ChildEntitySpecification.hasRank(request.getRank())));
//        return repository.findAll(spec);
//    }

    public List<ChildEntity> getAll() {
        return repository.findAll();
    }

    public ChildEntity getById(Long id) {
        return repository.getReferenceById(id);
    }

    public void save(ChildEntity child) {
        repository.save(child);
    }


    public ChildEntity update(Long id, ChildEntity child) {
        Optional<ChildEntity> optionalChildEntity = repository.findById(id);
        if (optionalChildEntity.isPresent()) {
            ChildEntity targetChildEntity = optionalChildEntity.get();
            targetChildEntity.setCode(child.getCode());
            targetChildEntity.setName(child.getName());
            return targetChildEntity;
        } else {
            throw new EntityNotFoundException("ChildEntity not found" + id);
        }
    }

    public ChildEntity findByName(String name) {
        Optional<ChildEntity> child = repository.findByName(name);
        return child.orElseThrow(()->new EntityNotFoundException("there is no child with this name"));
    }




}
