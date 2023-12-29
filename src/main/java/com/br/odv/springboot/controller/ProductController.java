package com.br.odv.springboot.controller;

import com.br.odv.springboot.domain.user.User;
import com.br.odv.springboot.dto.ProductDTO;
import com.br.odv.springboot.domain.product.Product;
import com.br.odv.springboot.domain.product.ProductCategoryEnum;
import com.br.odv.springboot.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
@Tag(name = "Product")
public class ProductController {

    @Autowired
    ProductService service;

    @PostMapping("/register")
    public ResponseEntity<ProductDTO> saveProduct(@AuthenticationPrincipal User user,
                                                  @RequestBody @Valid ProductDTO productDTO) {
        service.save(user, productDTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productDTO);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(@AuthenticationPrincipal User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll(user.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProduct(@AuthenticationPrincipal User user,
                                           @PathVariable String id) {
        Product product = service.getById(id);
        ProductDTO productDTO = new ProductDTO(product.getName(),
                product.getPrice(),
                product.getDescription(),
                product.isFeatured(),
                product.isOnOffer(),
                product.getCategory(),
                product.getAmount());

        if (user.equals(product.getUser())) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productDTO);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("Message", "Product Not Found"));
    }

    @GetMapping("/featured")
    public ResponseEntity<List<ProductDTO>> getFeaturedProduct(@AuthenticationPrincipal User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getFeatured(user.getId()));
    }

    @GetMapping("/offer")
    public ResponseEntity<List<ProductDTO>> getOfferProduct(@AuthenticationPrincipal User user) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getOffer(user.getId()));
    }

    @GetMapping("/categories")
    public ResponseEntity<ProductCategoryEnum[]> getCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ProductCategoryEnum.values());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@AuthenticationPrincipal User user,
                                           @PathVariable String id,
                                           @RequestBody @Valid ProductDTO productDTO) {

        Product product = service.getById(id);
        if (user.equals(product.getUser())) {
            service.update(id, product);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(productDTO);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(Map.of("Message", "Product Not Found"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@AuthenticationPrincipal User user,
                                           @PathVariable String id) {
        Product product = service.getById(id);
        if (user.equals(product.getUser())) {
            service.delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Product successfully removed");
        }
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
    }
}
