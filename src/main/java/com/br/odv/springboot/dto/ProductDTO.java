package com.br.odv.springboot.dto;

import com.br.odv.springboot.domain.product.ProductCategoryEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record ProductDTO(@NotBlank String name,
                         @NotNull BigDecimal price,
                         String description,
                         boolean isFeatured,
                         boolean isOnOffer,
                         @NotNull ProductCategoryEnum category,
                         int amount) {
}
