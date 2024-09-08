package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.dto.SupplierDto;
import com.SGInventario.invetario.entities.Supplier;
import com.SGInventario.invetario.repositories.SupplierRepository;
import com.SGInventario.invetario.services.exceptions.DatabaseException;
import com.SGInventario.invetario.services.exceptions.ResourceNotFoundException;

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
		Supplier entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
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

	
	
}
