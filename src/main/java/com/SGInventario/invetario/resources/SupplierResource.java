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

import com.SGInventario.invetario.dto.SupplierDto;
import com.SGInventario.invetario.services.SupplierService;

@RestController
@RequestMapping(value="/suppliers")
public class SupplierResource implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private SupplierService service;
	
	@GetMapping
	public ResponseEntity<List<SupplierDto>> findAll(){
		List<SupplierDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SupplierDto> findById(@PathVariable Long id){
		SupplierDto dto = service.findById(id); 
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping()
	public ResponseEntity<SupplierDto> insert(@RequestBody SupplierDto dto){
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.id())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SupplierDto> update(@PathVariable Long id, @RequestBody SupplierDto dto){
		dto = service.update(id, dto);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
