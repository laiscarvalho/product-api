package com.laiscarvalho.productapi.repository;


import com.laiscarvalho.productapi.dtos.ProductDto;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private Float price;

    private String description;

    private String productIdentifier;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public static Product convert(ProductDto productDto) {
        Product product = Product.builder()
                .name(productDto.getName())
                .price(productDto.getPrice())
                .description(productDto.getDescription())
                .productIdentifier(productDto.getProductIdentifier())
                .category(Category.convert(productDto.getCategory()))
                .build();

        return product;

    }
}
