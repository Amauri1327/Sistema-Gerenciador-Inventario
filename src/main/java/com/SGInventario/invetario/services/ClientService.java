package com.SGInventario.invetario.services;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SGInventario.invetario.dto.ClientDto;
import com.SGInventario.invetario.entities.Client;
import com.SGInventario.invetario.repositories.ClientRepository;

@Service
public class ClientService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientRepository repo;

	public List<ClientDto> findAll() {
		List<Client> entity = repo.findAll();
		return entity.stream().map(ClientDto:: new).collect(Collectors.toList());
	}

	
}
