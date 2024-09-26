package com.SGInventario.invetario.resources;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.SGInventario.invetario.dto.ClientDto;
import com.SGInventario.invetario.dto.ReportClientDto;
import com.SGInventario.invetario.services.ClientService;

@RestController
@RequestMapping(value="/clients")
public class ClientResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ClientService service;
	
	@GetMapping
	public ResponseEntity<List<ClientDto>> findAll(){
		List<ClientDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClientDto> findById(@PathVariable Long id){
		ClientDto dto = service.findById(id); 
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping()
	public ResponseEntity<ClientDto> insert(@RequestBody ClientDto dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.id())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClientDto> update(@PathVariable Long id, @RequestBody ClientDto dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/report/{id}")
	public ResponseEntity<ReportClientDto> generateClientReport(@PathVariable Long id){
		ReportClientDto dto = service.generatedClientReport(id);
		return ResponseEntity.ok(dto);
	}
	
	
}
