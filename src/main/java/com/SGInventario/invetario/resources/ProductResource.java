package com.SGInventario.invetario.resources;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SGInventario.invetario.dto.ProductDto;
import com.SGInventario.invetario.services.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<ProductDto>> findAll(){
		List<ProductDto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

}
