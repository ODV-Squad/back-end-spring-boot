package com.br.ebatista.springboot.domain.product;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table
@Data
public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id()
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private BigDecimal price;
    private String description;
    private boolean isFeatured;
    private boolean isOnOffer;
    @Enumerated(EnumType.STRING)
    private ProductCategoryEnum category;
}
