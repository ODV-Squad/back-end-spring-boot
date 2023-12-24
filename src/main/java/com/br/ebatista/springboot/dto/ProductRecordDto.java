package com.br.ebatista.springboot.dto;

import com.br.ebatista.springboot.model.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductRecordDto(@NotBlank String name,
                               @NotNull BigDecimal price,
                               String description,
                               boolean isFeatured,
                               boolean isOnOffer,
                               @NotNull ProductCategory category) {
}
