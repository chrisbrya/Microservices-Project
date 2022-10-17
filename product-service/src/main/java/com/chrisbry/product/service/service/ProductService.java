package com.chrisbry.product.service.service;

import com.chrisbry.product.service.entity.Product;
import com.chrisbry.product.service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product saveProduct(Product product) {
        log.info("Inside saveProduct of ProductService");
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        log.info("Inside getAllProducts of ProductService");
        return productRepository.findAll();
    }

    public Product findByProductId(Long productId) {
        log.info("Inside findProductById of ProductService");
        return productRepository.findByProductId(productId);

    }
}
