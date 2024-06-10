package com.example.unit.relations;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "parent_entity")
public class ParentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parent_id")
    private Long id;

    @Column
    private String name;
    @Column
    private int code;

    @OneToMany(mappedBy = "parentEntity",cascade = CascadeType.ALL)
    private List<ChildEntity> childEntities;
}
