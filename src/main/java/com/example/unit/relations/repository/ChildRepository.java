package com.example.unit.relations.repository;


import com.example.unit.relations.ChildEntity;
import com.example.unit.relations.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChildRepository extends JpaRepository<ChildEntity,Long> {
    List<ChildEntity> findAllByParentEntity(ParentEntity entity);
    Optional<ChildEntity> findByName(String name);
}
