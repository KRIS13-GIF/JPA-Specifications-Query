package com.example.specifications.services;

import com.example.specifications.entity.Customer;
import com.example.specifications.models.CustomerResponse;
import com.example.specifications.repositories.CustomerRepository;
import com.example.specifications.specification.CustomerSpecs;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServices {

    private final CustomerRepository customerRepository;


    public List<CustomerResponse> getCustomersWithSalesGreaterThan50() {
        List<Customer> customerList = customerRepository.findAll(CustomerSpecs.salesGreaterThan50());
        return customerList.stream()
                .map(customer -> new CustomerResponse(customer.getName()))
                .collect(Collectors.toList());
    }

    //Combined Specifications
    public List<CustomerResponse>getCustomerWithSalesGreaterThan50AndPointsLessThan30(){
        List<Customer> customerList = customerRepository.findAll(CustomerSpecs.salesGreaterThan50().and(CustomerSpecs.pointsLessThan30()));
        return customerList.stream()
                .map(customer -> new CustomerResponse(customer.getName()))
                .collect(Collectors.toList());
    }




}
