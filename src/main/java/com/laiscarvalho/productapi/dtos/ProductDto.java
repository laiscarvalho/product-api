package com.laiscarvalho.productapi.dtos;


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






}
