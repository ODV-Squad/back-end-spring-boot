package com.br.odv.springboot.integration.service;

import com.br.odv.springboot.domain.product.Product;
import com.br.odv.springboot.domain.product.ProductCategoryEnum;
import com.br.odv.springboot.domain.user.User;
import com.br.odv.springboot.domain.user.UserRole;
import com.br.odv.springboot.dto.ProductDTO;
import com.br.odv.springboot.repository.ProductRepository;
import com.br.odv.springboot.repository.UserRepository;
import com.br.odv.springboot.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class IProductTest {

    @Autowired
    ProductService productService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepository productRepository;

    List<Product> products = new ArrayList<>();
    List<ProductDTO> productsDTO = new ArrayList<>();
    User user;

    @BeforeEach
    public void saveUserAndProduct() {
     user = new User("a@a.com", "pass123", UserRole.USER);
        userRepository.save(user);
        Product product = Product.builder()
                .id("1")
                .name("iPhone")
                .price(new BigDecimal("8000.00"))
                .amount(2)
                .description("iPhone description")
                .user(user)
                .isFeatured(true)
                .isOnOffer(true)
                .category(ProductCategoryEnum.ELECTRONIC)
                .build();

        ProductDTO productDTO = new ProductDTO(product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.isFeatured(),
                product.isOnOffer(),
                product.getCategory(),
                product.getAmount());

        products.add(product);
        productsDTO.add(productDTO);

        productService.save(user, productDTO);
    }
    @Test
    public void shouldGetAllProductsTest() {
        List<ProductDTO> allProducts = productService.getAll(user.getId());
        assertEquals(productsDTO, allProducts);
    }
}
