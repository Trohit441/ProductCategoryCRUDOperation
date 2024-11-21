package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.CategoryDao;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Page<Product> getAllProducts(Pageable pageable) {
        return productDao.findAll(pageable);
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product createProduct(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product updatedProduct) {
        Product product = productDao.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());
        product.setCategory(updatedProduct.getCategory());
        return productDao.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
    	productDao.deleteById(id);
    }
}

