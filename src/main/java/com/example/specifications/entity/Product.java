package com.example.specifications.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private String description;

    @ManyToOne
    Customer customer;

    public Product(Long id, double price, String description) {
        this.id = id;
        this.price = price;
        this.description = description;
    }






}
