package com.SGInventario.invetario.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.SGInventario.invetario.services.ClientService;

@RestController
public class ClientResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService service;
}
