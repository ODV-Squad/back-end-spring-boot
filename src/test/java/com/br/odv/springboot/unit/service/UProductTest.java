package com.br.odv.springboot.unit.service;

import com.br.odv.springboot.domain.product.Product;
import com.br.odv.springboot.domain.product.ProductCategoryEnum;
import com.br.odv.springboot.domain.user.User;
import com.br.odv.springboot.domain.user.UserRole;
import com.br.odv.springboot.dto.ProductDTO;
import com.br.odv.springboot.repository.ProductRepository;
import com.br.odv.springboot.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class UProductTest {

    @InjectMocks
    ProductService service;

    @Mock
    ProductRepository repository;

    User user = new User("1", "a@a.com", "pass123", UserRole.USER);
    List<Product> products = new ArrayList<>();
    List<ProductDTO> productsDTO = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        Product product = Product.builder()
                .id("1")
                .name("iPhone")
                .price(new BigDecimal("8000"))
                .amount(2)
                .description("iPhone description")
                .user(user)
                .isFeatured(true)
                .isOnOffer(true)
                .category(ProductCategoryEnum.ELECTRONIC)
                .build();

        ProductDTO productDTO = ProductDTO.builder()
                .name(product.getName())
                .price(product.getPrice())
                .amount(product.getAmount())
                .description(product.getDescription())
                .isFeatured(product.isFeatured())
                .isOnOffer(product.isOnOffer())
                .category(product.getCategory())
                .build();

        products.add(product);
        productsDTO.add(productDTO);
    }

    @Test
    public void shouldGetAllProductsTest() {
        Mockito.when(repository.findByUserId(user.getId()))
                .thenReturn(productsDTO);
        List<ProductDTO> allProducts = service.getAll(user.getId());
        assertEquals(productsDTO, allProducts);
    }
}
