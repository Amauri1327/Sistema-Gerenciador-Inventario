package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.dto.ClientDto;
import com.SGInventario.invetario.entities.Client;
import com.SGInventario.invetario.repositories.ClientRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClientService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientRepository repo;

	public List<ClientDto> findAll() {
		List<Client> entity = repo.findAll();
		return entity.stream().map(ClientDto:: new).collect(Collectors.toList());
	}
	
	@Transactional
	public ClientDto findById(Long id) {
		Optional<Client> obj = repo.findById(id);
		Client entity = obj.orElseThrow(() -> new RuntimeException("Id not found"));
		return new ClientDto(entity);
	}

	@Transactional
	public ClientDto insert(ClientDto dto) {
		Client entity = new Client();
		entity.setName(dto.name());
		entity.setCpf(dto.cpf());
		entity.setAddress(dto.address());
		entity.setPhone(dto.phone());
		repo.save(entity);
		return new ClientDto(entity);
	}

	@Transactional
	public ClientDto update(Long id, ClientDto dto) {
		try{
			Client entity = repo.getReferenceById(id);
			entity.setName(dto.name());
			entity.setCpf(dto.cpf());
			entity.setAddress(dto.address());
			entity.setPhone(dto.phone());
			repo.save(entity);
			return new ClientDto(entity);
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
