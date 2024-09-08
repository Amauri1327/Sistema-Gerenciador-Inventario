package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.SGInventario.invetario.dto.ProductDto;
import com.SGInventario.invetario.entities.Product;
import com.SGInventario.invetario.repositories.ProductRepository;

public class ProductService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductRepository repo;

	public List<ProductDto> findAll(){
		List<Product> entity = repo.findAll();
		return entity.stream().map(ProductDto::new).collect(Collectors.toList());
	}
	
	
}
