package com.example.specifications.controller;

import com.example.specifications.entity.Customer;
import com.example.specifications.entity.CustomerProfile;
import com.example.specifications.models.CustomerRequest;
import com.example.specifications.models.CustomerResponse;
import com.example.specifications.services.CustomerServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/ageBetween18And25")
    public List<CustomerResponse>getAgeBetween18And25(){
        return customerServices.getCustomerAgeBetween18And25();
    }

    @GetMapping("/customer-profiles")
    public List<CustomerProfile> findCustomerProfilesWithUserProfileInfo(@RequestParam String keyword) {
        return customerServices.findCustomerProfilesWithUserProfileInfo(keyword);
    }

}
