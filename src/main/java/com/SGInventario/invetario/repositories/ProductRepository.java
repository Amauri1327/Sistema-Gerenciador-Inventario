package com.SGInventario.invetario.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SGInventario.invetario.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
