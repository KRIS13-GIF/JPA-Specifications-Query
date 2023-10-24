package com.example.specifications.specification;

import com.example.specifications.entity.Product;
import com.example.specifications.utils.QueryUtils;
import org.springframework.data.jpa.domain.Specification;



public class ProductSpecs {

    public static Specification<Product> findProductsByCustomerId(Long customerId) {
        return (root, query, criteriaBuilder) -> {
            return criteriaBuilder.equal(root.get("customer").get("id"), customerId);
        };
    }

    public static Specification<Product>partialProductDescription(String description){
        String partialStringWithPercentage= QueryUtils.addPercentageFull(description);
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(
                root.get("description"),partialStringWithPercentage
        ));
    }

}
