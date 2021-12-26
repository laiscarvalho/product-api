package com.laiscarvalho.productapi.controller;


import com.laiscarvalho.productapi.dtos.ProductDto;
import com.laiscarvalho.productapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/product")
    public List<ProductDto> getProducts() {
        List<ProductDto> products = productService.getAll();
        return products;
    }

    @GetMapping(value = "/product/category/{categoryId}")
    public List<ProductDto> getProductsByCategory(@PathVariable Long categoryId) {
        List<ProductDto> productsByCategory = productService.getProductByCategoryId(categoryId);
        return productsByCategory;

    }

    @GetMapping(value = "product/{productId}")
    public ProductDto getProductById(@PathVariable String productId) {
        ProductDto productById = productService.findByProductIdentifier(productId);
        return productById;
    }

    @PostMapping("/product")
    public ProductDto newProduct(@Valid @RequestBody ProductDto productDto) {
        return productService.save(productDto);

    }

    @DeleteMapping("/product/{id}")
    public ProductDto deleteProduct(@PathVariable Long productId) {
        productService.delete(productId);
        return null;
    }

}
