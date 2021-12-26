package com.laiscarvalho.productapi.services;

import com.laiscarvalho.productapi.dtos.ProductDto;
import com.laiscarvalho.productapi.repository.Product;
import com.laiscarvalho.productapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<ProductDto> getAll() {
        List<Product> products = productRepository.findAll();
        return products
                .stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());
    }

    public List<ProductDto> getProductByCategoryId(Long categoryId) {
        List<Product> products = productRepository.getProductByCategory(categoryId);
        return products
                .stream()
                .map(ProductDto::convert)
                .collect(Collectors.toList());
    }

    public ProductDto save(ProductDto productDto) {
        Product product = productRepository.save(Product.convert(productDto));
        return ProductDto.convert(product);
    }

    public void delete(long productId) {
        Optional<Product> Product = productRepository.findById(productId);
        if (Product.isPresent()) {
            productRepository.delete(Product.get());
        }
    }

    public ProductDto findByProductIdentifier(String productIdentifier) {
        Product product = productRepository.findByProductIdentifier(productIdentifier);
        if (product != null) {
            return ProductDto.convert(product);
        }
        return null;
    }
}
