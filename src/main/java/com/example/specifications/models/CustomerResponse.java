package com.example.specifications.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerResponse {
    private Long id;
    String name;
    String email;
    String loyalty_level;

    public CustomerResponse(String email, String loyalty_level) {

        this.email = email;
        this.loyalty_level = loyalty_level;
    }

    public CustomerResponse(String name){
        this.name=name;
    }

}
