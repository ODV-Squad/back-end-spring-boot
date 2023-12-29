package com.br.odv.springboot.service;

import com.br.odv.springboot.domain.product.Product;
import com.br.odv.springboot.domain.user.User;
import com.br.odv.springboot.dto.ProductDTO;
import com.br.odv.springboot.repository.ProductRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product save(User user, ProductDTO productDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);
        product.setUser(user);
        return repository.save(product);
    }

    public List<ProductDTO> getAll(String userId) {
        return repository.findByUserId(userId);
    }

    public Product getById(String id) {
        return repository.findById(id).orElseThrow();
    }

    public List<ProductDTO> getFeatured(String userId) {
        return repository.findByUserId(userId)
                .stream()
                .filter(ProductDTO::isFeatured)
                .collect(Collectors.toList());
    }
    public Product update(String id, Product product) {
        product.setId(id);
        return repository.save(product);
    }

    public void delete(String id) {
        repository.deleteById(id);
    }

    public List<ProductDTO> getOffer(String userId) {
        return repository.findByUserId(userId)
                .stream()
                .filter(ProductDTO::isOnOffer)
                .collect(Collectors.toList());
    }
}
