package com.example.specifications.specification;

import com.example.specifications.entity.Customer;
import com.example.specifications.entity.CustomerProfile;
import com.example.specifications.utils.QueryUtils;
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

    public static Specification<Customer>findCustomerWithProfileKeyword(String keyword){
        String keywordWithPercentage= QueryUtils.addPercentageFull(keyword);
        return ((root, query, criteriaBuilder) -> {
            Subquery<Boolean>subquery= query.subquery(Boolean.class);
            Root<CustomerProfile>subqueryRoot=subquery.from(CustomerProfile.class);

            return criteriaBuilder.exists(
                    subquery.select(criteriaBuilder.literal(true))
                            .where(criteriaBuilder.and(
                                    criteriaBuilder.equal(root.get("id"), subqueryRoot.get("customer_id")),
                                    criteriaBuilder.like(subqueryRoot.get("phoneNumber"),keywordWithPercentage)
                            ))
            );


        });
    }




}
