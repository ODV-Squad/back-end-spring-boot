package com.br.ebatista.springboot.controller;

import com.br.ebatista.springboot.dto.ProductRecordDto;
import com.br.ebatista.springboot.model.Product;
import com.br.ebatista.springboot.repository.ProductRepository;
import com.br.ebatista.springboot.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ProductController {
    //TODO: Implementar filtros
    //TODO: Implementar paginação

    @Autowired
    ProductService service;

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.save(product));
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getOneProduct(@PathVariable UUID id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.getById(id));
        } catch (RuntimeException ex) { // TODO: Criar tratativa de exceção
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
        }
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable UUID id,
                                    @RequestBody @Valid ProductRecordDto productRecordDto) {
        var product = new Product();
        BeanUtils.copyProperties(productRecordDto, product);
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(service.update(id, product));
        } catch (RuntimeException ex) { // TODO: Criar tratativa de exceção
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
        }
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable UUID id) {
        try {
            service.getById(id);
            service.delete(id);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("Product successfully removed");
        } catch (RuntimeException ex) { // TODO: Criar tratativa de exceção
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("Message", "Product Not Found"));
        }
    }
}
