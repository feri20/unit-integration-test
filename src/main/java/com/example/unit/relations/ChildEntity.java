package com.example.unit.relations;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "child_entity")
public class ChildEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column
        private String name;
        @Column
        private int code;

        @ManyToOne
        @JoinColumn(name = "parent_id")
        private ParentEntity parentEntity;
}
