package com.example.specifications.controller;

import com.example.specifications.entity.Customer;
import com.example.specifications.models.CustomerResponse;
import com.example.specifications.services.CustomerServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
@AllArgsConstructor
public class CustomerController {


    private final CustomerServices customerServices;


    @GetMapping("/salesGreaterThan50")
    public List<CustomerResponse> getCustomersWithSalesGreaterThan50() {
        return customerServices.getCustomersWithSalesGreaterThan50();
    }

    @GetMapping("/salesGreaterThan50andPointsLessThan30")
    public List<CustomerResponse>getsalesGreaterThan50andPointsLessThan30(){
        return customerServices.getCustomerWithSalesGreaterThan50AndPointsLessThan30();
    }



}
