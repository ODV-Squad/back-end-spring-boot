package com.br.ebatista.springboot.service;

import com.br.ebatista.springboot.domain.product.Product;
import com.br.ebatista.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }

    public Product getById(UUID id) {
        return repository.findById(id).orElseThrow();
    }

    public List<Product> getFeatured() {
        return repository.findAll()
                .stream()
                .filter(Product::isFeatured)
                .collect(Collectors.toList());
    }
    public Product update(UUID id, Product product) {
        product.setId(id);
        return save(product);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }

    public List<Product> getOffer() {
        return repository.findAll()
                .stream()
                .filter(Product::isOnOffer)
                .collect(Collectors.toList());
    }
}
