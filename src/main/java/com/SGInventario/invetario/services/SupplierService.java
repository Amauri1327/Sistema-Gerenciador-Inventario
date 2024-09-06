package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.dto.SupplierDto;
import com.SGInventario.invetario.entities.Supplier;
import com.SGInventario.invetario.repositories.SupplierRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class SupplierService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SupplierRepository repo;

	public List<SupplierDto> findAll() {
		List<Supplier> entity = repo.findAll();
		return entity.stream().map(SupplierDto:: new).collect(Collectors.toList());
	}
	
	@Transactional
	public SupplierDto findById(Long id) {
		Optional<Supplier> obj = repo.findById(id);
		Supplier entity = obj.orElseThrow(() -> new RuntimeException("Id not found"));
		return new SupplierDto(entity);
	}

	@Transactional
	public SupplierDto insert(SupplierDto dto) {
		Supplier entity = new Supplier();
		entity.setName(dto.name());
		entity.setCnpj(dto.cnpj());
		entity.setAddress(dto.address());
		entity.setPhone(dto.phone());
		repo.save(entity);
		return new SupplierDto(entity);
	}

	@Transactional
	public SupplierDto update(Long id, SupplierDto dto) {
		try{
			Supplier entity = repo.getReferenceById(id);
			entity.setName(dto.name());
			entity.setCnpj(dto.cnpj());
			entity.setAddress(dto.address());
			entity.setPhone(dto.phone());
			repo.save(entity);
			return new SupplierDto(entity);
		}
		catch(EntityNotFoundException e) {
			 throw new EntityNotFoundException("Id not found: " + id);
		}
	}
	
	@Transactional
	public void delete(Long id) {
		try {
			repo.deleteById(id);
		}catch(EntityNotFoundException e) {
			throw new EntityNotFoundException("Id not found: " + id);
		}
	}
	
	
	
}
