package com.example.specifications.controller;


import com.example.specifications.entity.Product;

import com.example.specifications.models.ProductResponse;
import com.example.specifications.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/customer/{id}")
    public List<ProductResponse>getProductByCustomerId(@PathVariable Long id)
            throws Exception
    {
        return productService.findProductsByCustomer(id);
    }




}
