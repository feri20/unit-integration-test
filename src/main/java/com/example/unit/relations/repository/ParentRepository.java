package com.example.unit.relations.repository;


import com.example.unit.relations.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParentRepository extends JpaRepository<ParentEntity,Long> {
    Optional<ParentEntity> findByName(String name);


}
