package com.SGInventario.invetario.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SGInventario.invetario.entities.Client;
import com.SGInventario.invetario.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<Client>> findAll(){
		List<Client> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
}
