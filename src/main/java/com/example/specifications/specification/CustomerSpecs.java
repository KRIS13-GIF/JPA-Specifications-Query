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

    /*  // No need in the service. Is already implemented inside it.

    public static Specification<Customer> findUserProfileInfo(String keyword) {
        return (root, query, criteriaBuilder) -> {

            root.join("customerProfile");

            // Add criteria to your query based on the properties of CustomerProfile
            return criteriaBuilder.or(
                    criteriaBuilder.like(root.get("customerProfile.email"), "%" + keyword + "%"),
                    criteriaBuilder.like(root.get("customerProfile.address"), "%" + keyword + "%"),
                    criteriaBuilder.like(root.get("customerProfile.phoneNumber"), "%" + keyword + "%"),
                    criteriaBuilder.like(root.get("customerProfile.loyaltyLevel"), "%" + keyword + "%"),
                    criteriaBuilder.like(root.get("customerProfile.notes"), "%" + keyword + "%")
            );
        };
    }*/
}


