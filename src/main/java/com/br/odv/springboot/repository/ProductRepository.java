package com.br.odv.springboot.repository;

import com.br.odv.springboot.domain.product.Product;
import com.br.odv.springboot.dto.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<ProductDTO> findByUserId(String userId);
}
