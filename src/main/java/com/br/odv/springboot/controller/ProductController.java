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
        String userId = user.getId();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable UUID id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.getById(id));
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
        }
    }

    @GetMapping("/featured")
    public ResponseEntity<List<Product>> getFeaturedProduct() {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.getFeatured());
    }

    @GetMapping("/offer")
    public ResponseEntity<List<Product>> getOfferProduct() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getOffer());
    }

    @GetMapping("/categories")
    public ResponseEntity<ProductCategoryEnum[]> getCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ProductCategoryEnum.values());
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<?> updateProduct(@PathVariable UUID id,
//                                    @RequestBody @Valid ProductDTO productRecordDto) {
//        var product = new Product();
//        BeanUtils.copyProperties(productRecordDto, product);
//        try {
//            return ResponseEntity
//                    .status(HttpStatus.OK)
//                    .body(service.update(id, product));
//        } catch (RuntimeException ex) {
//            return ResponseEntity
//                    .status(HttpStatus.NOT_FOUND)
//                    .body(Map.of("Message", "Product Not Found"));
//        }
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        try {
            service.getById(id);
            service.delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Product successfully removed");
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
        }
    }
}
