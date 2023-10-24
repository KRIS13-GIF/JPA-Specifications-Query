package com.example.specifications.specification;

import com.example.specifications.entity.Customer;
import com.example.specifications.entity.CustomerProfile;
import com.example.specifications.utils.QueryUtils;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;
import org.springframework.data.jpa.domain.Specification;


public class CustomerSpecs {
    public static Specification<Customer> salesGreaterThan50() {
        return (root, query, builder) -> builder.greaterThan(root.get("sales"), 50.0);
    }

    public static Specification<Customer>pointsLessThan30(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("points"),20));
    }

    public static Specification<Customer>ageBetween18And25(){
        return (((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("age"),18,25)));
    }

}


