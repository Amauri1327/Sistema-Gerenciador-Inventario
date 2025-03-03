package com.SGInventario.invetario.core.ports;

import com.SGInventario.invetario.core.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);
    void deleteById(Long id);
}
