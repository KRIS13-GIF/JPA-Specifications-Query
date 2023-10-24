package com.example.specifications.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerProfile {

    @Id
    private Long id;
    private String email;
    private String address;
    private String phoneNumber;
    private boolean isPreferredCustomer;
    private String loyaltyLevel;
    private String notes;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
