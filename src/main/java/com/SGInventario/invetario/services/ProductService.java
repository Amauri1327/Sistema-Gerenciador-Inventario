package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.dto.ProductDto;
import com.SGInventario.invetario.entities.Product;
import com.SGInventario.invetario.repositories.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductRepository repo;

	public List<ProductDto> findAll(){
		List<Product> entity = repo.findAll();
		return entity.stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public ProductDto findById(Long id) {
		Optional<Product> obj = repo.findById(id);
		Product entity = obj.orElseThrow(() -> new RuntimeException("Id not found"));
		return new ProductDto(entity);
	}
	
	@Transactional
	public ProductDto insert(ProductDto dto) {
		Product prod = new Product();
		prod.setName(dto.name());
		prod.setDescription(dto.description());
		prod.setQuantity(dto.quantity());
		prod.setCategory(dto.category());
		prod.setMaxStock(dto.maxStock());
		prod.setMinStock(dto.minStock());
		repo.save(prod);
		return new ProductDto(prod);
	}

	@Transactional
	public ProductDto update(Long id, ProductDto dto) {
		try {
			Product prod = repo.getReferenceById(id);
			prod.setName(dto.name());
			prod.setDescription(dto.description());
			prod.setQuantity(dto.quantity());
			prod.setCategory(dto.category());
			prod.setMaxStock(dto.maxStock());
			prod.setMinStock(dto.minStock());
			repo.save(prod);
			return new ProductDto(prod);
		}catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found: " + id);
		}
	}
	
	@Transactional
	public void delete(long id) {
		try {
			repo.deleteById(id);
		}
		catch (EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found: " + id);
		}
		
	}
	
	
}
