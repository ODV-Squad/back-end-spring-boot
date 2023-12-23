package com.br.ebatista.springboot.service;

import com.br.ebatista.springboot.model.Product;
import com.br.ebatista.springboot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

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

    public Product update(UUID id, Product product) {
        product.setId(id);
        return save(product);
    }

    public void delete(UUID id) {
        repository.deleteById(id);
    }
}
