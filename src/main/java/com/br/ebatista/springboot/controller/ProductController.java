package com.br.ebatista.springboot.controller;

import com.br.ebatista.springboot.dto.ProductRecordDto;
import com.br.ebatista.springboot.domain.product.Product;
import com.br.ebatista.springboot.domain.product.ProductCategoryEnum;
import com.br.ebatista.springboot.service.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(product));
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
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

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable UUID id,
                                    @RequestBody @Valid ProductRecordDto productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.update(id, product));
        } catch (RuntimeException ex) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
        }
    }

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
