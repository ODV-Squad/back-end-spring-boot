package com.br.ebatista.springboot.domain.sales;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
}
