package com.example.specifications.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponse {

    private Long id;
    private double price;
    private String description;
    private String customerName;

}
