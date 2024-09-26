package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.component.ProductRules;
import com.SGInventario.invetario.dto.ProductDto;
import com.SGInventario.invetario.entities.Product;
import com.SGInventario.invetario.repositories.ProductRepository;
import com.SGInventario.invetario.services.exceptions.DatabaseException;
import com.SGInventario.invetario.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ProductService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ProductRules rules;

	public List<ProductDto> findAll(){
		List<Product> entity = repo.findAll();
		return entity.stream().map(ProductDto::new).collect(Collectors.toList());
	}

	public ProductDto findById(Long id) {
		Optional<Product> obj = repo.findById(id);
		Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new ProductDto(entity);
	}
	
	@Transactional
	public ProductDto insert(ProductDto dto) {
		Product prod = new Product();
		prod.setName(dto.name());
		prod.setDescription(dto.description());
		prod.setPrice(dto.price());
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
			prod.setPrice(dto.price());
			prod.setQuantity(dto.quantity());
			prod.setCategory(dto.category());
			prod.setMaxStock(dto.maxStock());
			prod.setMinStock(dto.minStock());
			repo.save(prod);
			return new ProductDto(prod);
		}catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}
	}
	
	@Transactional
	public void delete(Long id) {
	    if (!repo.existsById(id)) {
	        throw new ResourceNotFoundException("Id not found: " + id);
	    }
	    try {
	        repo.deleteById(id);
	    } catch (DataIntegrityViolationException e) {
	        throw new DatabaseException("Integrity violation");
	    }
	}
	
	public List<ProductDto> generateProductReport(){
		List<Product> prod = repo.findAll();
		return rules.generateProductReport(prod);	
	}
	
}
