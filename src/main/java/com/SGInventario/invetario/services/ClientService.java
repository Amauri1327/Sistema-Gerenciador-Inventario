package com.SGInventario.invetario.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import com.SGInventario.invetario.repositories.ClientRepository;

public class ClientService implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientRepository repo;

	
}
