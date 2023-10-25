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
    private String loyalty_level;
    private String notes;

    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;




    public CustomerProfile(Long id,String email, String address, String phoneNumber, String loyalty_level, String notes) {
        this.id=id;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.loyalty_level = loyalty_level;
        this.notes = notes;
    }
}
