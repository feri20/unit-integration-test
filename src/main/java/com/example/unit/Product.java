package com.example.unit;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Column(name = "product_id", updatable = false, unique = true)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Column
    private Long price;

    @Column
    private int rank;

    public Product() {

    }


    public Long showPrice(){
        return this.price;
    }

    public Product(String name, String code, Long price, int rank) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.rank = rank;
    }

    public Product(Long id, String name, String code, Long price, int rank) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.price = price;
        this.rank = rank;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", price=" + price +
                ", rank=" + rank +
                '}';
    }
}
