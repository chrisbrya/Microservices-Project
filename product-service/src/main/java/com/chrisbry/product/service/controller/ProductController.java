package com.chrisbry.product.service.controller;

import com.chrisbry.product.service.entity.Product;
import com.chrisbry.product.service.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product saveProduct(@RequestBody Product product){
        log.info("Inside saveProduct of ProductController");
        return productService.saveProduct(product);
    }

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts(){
        log.info("Inside getAllProducts of ProductController");
       return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product findProductById(@PathVariable("id") Long productId) {
        log.info("Inside findProductById of ProductController");
        return productService.findByProductId(productId);
    }
}
