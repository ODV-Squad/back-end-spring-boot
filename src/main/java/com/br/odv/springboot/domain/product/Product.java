package com.br.odv.springboot.domain.product;

import com.br.odv.springboot.domain.user.User;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

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
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private BigDecimal price;
    private String description;
    private boolean isFeatured;
    private boolean isOnOffer;
    @Enumerated(EnumType.STRING)
    private ProductCategoryEnum category;
    private int amount;
    @ManyToOne @JoinColumn(name = "user_id")
    private User user;
}
