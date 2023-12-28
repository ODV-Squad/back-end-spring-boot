package com.br.ebatista.springboot.domain.sales;

import com.br.ebatista.springboot.domain.product.Product;
import com.br.ebatista.springboot.domain.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Sales {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private List<Product> products;
    private User user;
    private BigDecimal totalValue;
    private LocalDateTime timestamp;
    private Address address;
    private String payment;

}
