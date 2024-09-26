package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.component.ClientRules;
import com.SGInventario.invetario.dto.ClientDto;
import com.SGInventario.invetario.dto.ReportClientDto;
import com.SGInventario.invetario.entities.Client;
import com.SGInventario.invetario.repositories.ClientRepository;
import com.SGInventario.invetario.services.exceptions.DatabaseException;
import com.SGInventario.invetario.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClientService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientRepository repo;

	@Autowired
	private ClientRules rules;
	
	public List<ClientDto> findAll() {
		List<Client> entity = repo.findAll();
		return entity.stream().map(ClientDto:: new).collect(Collectors.toList());
	}
	
	@Transactional
	public ClientDto findById(Long id) {
		Optional<Client> obj = repo.findById(id);
		Client entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
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

	@Transactional
	public ReportClientDto generatedClientReport(Long id){
		Client cli = repo.findById(id).get();
		return rules.generateClientReport(cli);
	}
	
}
