package com.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.demo.beans.Product;

public interface ProductService {
    Page<Product> getAllProducts(Pageable pageable);
    Product getProductById(Long id);
    Product createProduct(Product product);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
}

