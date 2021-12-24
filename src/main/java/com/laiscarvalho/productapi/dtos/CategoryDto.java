package com.laiscarvalho.productapi.dtos;

import com.laiscarvalho.productapi.repository.Category;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Builder
@Data
public class CategoryDto {
    @NotNull
    private long id;

    private String name;

    public static CategoryDto convert(Category category) {
        CategoryDto categoryDto = CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
        return categoryDto;
    }

}
