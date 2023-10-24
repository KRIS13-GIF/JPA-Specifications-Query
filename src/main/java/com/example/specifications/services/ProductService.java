package com.example.specifications.services;

import com.example.specifications.entity.Product;
import com.example.specifications.specification.ProductSpecs;
import jakarta.persistence.EntityManager;
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


    public List<Product> findProductsByCustomer(Long customerId) {
        Specification<Product> spec = ProductSpecs.findProductsByCustomerId(customerId);

        CriteriaBuilder criteriaBuilder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteriaQuery = criteriaBuilder.createQuery(Product.class);
        Root<Product> productRoot = criteriaQuery.from(Product.class);

        criteriaQuery.select(criteriaBuilder.construct(
                Product.class,
                productRoot.get("id"),
                productRoot.get("price"),
                productRoot.get("description")
        ));

        // Apply the Specification to the criteria query
        if (spec != null) {
            criteriaQuery.where(spec.toPredicate(productRoot, criteriaQuery, criteriaBuilder));
        }

        return this.entityManager.createQuery(criteriaQuery).getResultList();
    }





}
