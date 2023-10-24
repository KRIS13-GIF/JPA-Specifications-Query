package com.example.specifications.services;

import com.example.specifications.entity.Product;
import com.example.specifications.models.ProductResponse;
import com.example.specifications.specification.ProductSpecs;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private EntityManager entityManager;

    @Autowired
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public List<ProductResponse> findProductsByCustomer(Long customerId) {
        Specification<Product> spec = ProductSpecs.findProductsByCustomerId(customerId);

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductResponse> criteriaQuery = criteriaBuilder.createQuery(ProductResponse.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        criteriaQuery.select(criteriaBuilder.construct(
                ProductResponse.class,
                productRoot.get("id"),
                productRoot.get("price"),
                productRoot.get("description")
        ));

        // Apply the Specification to the criteria query
        if (spec != null) {
            criteriaQuery.where(spec.toPredicate(productRoot, criteriaQuery, criteriaBuilder));
        }

        TypedQuery<ProductResponse> query = this.entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }






}
