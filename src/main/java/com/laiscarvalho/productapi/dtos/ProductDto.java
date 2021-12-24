package com.laiscarvalho.productapi.dtos;


import com.laiscarvalho.productapi.repository.Category;
import com.laiscarvalho.productapi.repository.Product;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class ProductDto {

    @NotBlank
    private String productIdentifier;

    @NotBlank
    private String name;

    @NotNull
    private Float price;

    @NotBlank
    private String description;

    @NotNull
    private CategoryDto category;

    public static ProductDto convert (Product product){
        ProductDto productDto = ProductDto.builder()
                .name(product.getName())
                .productIdentifier(product.getProductIdentifier())
                .price(product.getPrice())
                .description(product.getDescription())
                .category(CategoryDto.convert((Category) product.getCategory()))
                .build();

        return productDto;

    }






}
