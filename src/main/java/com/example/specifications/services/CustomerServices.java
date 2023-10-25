package com.example.specifications.services;

import com.example.specifications.entity.Customer;
import com.example.specifications.entity.CustomerProfile;
import com.example.specifications.entity.Product;
import com.example.specifications.models.CustomerResponse;
import com.example.specifications.models.ProductResponse;
import com.example.specifications.repositories.CustomerRepository;
import com.example.specifications.specification.CustomerSpecs;
import com.example.specifications.specification.ProductSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerServices {

    private final CustomerRepository customerRepository;
    private EntityManager entityManager;



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

    public List<CustomerResponse>getCustomerAgeBetween18And25(){
        List<Customer> customerList = customerRepository.findAll(CustomerSpecs.ageBetween18And25());
        return customerList.stream()
                .map(customer -> new CustomerResponse(customer.getName()))
                .collect(Collectors.toList());
    }


    public List<CustomerProfile> findCustomerProfilesWithUserProfileInfo(String keyword) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<CustomerProfile> query = criteriaBuilder.createQuery(CustomerProfile.class);
        Root<CustomerProfile> profileRoot = query.from(CustomerProfile.class);

        // Create a list of predicates for filtering (Do not type @RequestBody, use @RequestParams in your controller)
        Predicate emailPredicate = criteriaBuilder.like(profileRoot.get("email"), "%" + keyword + "%");
        Predicate addressPredicate = criteriaBuilder.like(profileRoot.get("address"), "%" + keyword + "%");
        Predicate phonePredicate = criteriaBuilder.like(profileRoot.get("phoneNumber"), "%" + keyword + "%");
        Predicate loyaltyPredicate = criteriaBuilder.like(profileRoot.get("loyalty_level"), "%" + keyword + "%");
        Predicate notesPredicate = criteriaBuilder.like(profileRoot.get("notes"), "%" + keyword + "%");

        Predicate orPredicate = criteriaBuilder.or(emailPredicate, addressPredicate, phonePredicate, loyaltyPredicate, notesPredicate);


        query.where(orPredicate);

        query.select(criteriaBuilder.construct(
                CustomerProfile.class,
                profileRoot.get("id"),
                profileRoot.get("email"),
                profileRoot.get("address"),
                profileRoot.get("phoneNumber"),
                profileRoot.get("loyalty_level"),
                profileRoot.get("notes"),
                profileRoot.get("customer")
        ));


        return entityManager.createQuery(query).getResultList();
    }





}
