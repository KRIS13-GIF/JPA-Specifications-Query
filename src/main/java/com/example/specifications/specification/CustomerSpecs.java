package com.example.specifications.specification;

import com.example.specifications.entity.Customer;
import org.springframework.data.jpa.domain.Specification;


public class CustomerSpecs {
    public static Specification<Customer> salesGreaterThan50() {
        return (root, query, builder) -> builder.greaterThan(root.get("sales"), 50.0);
    }

    public static Specification<Customer>pointsLessThan30(){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("points"),20));
    }


}
