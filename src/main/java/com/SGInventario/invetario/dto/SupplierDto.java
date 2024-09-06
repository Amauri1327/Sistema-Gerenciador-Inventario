package com.SGInventario.invetario.dto;

import com.SGInventario.invetario.entities.Supplier;

public record SupplierDto(
		Long id,
		String name,
		String cnpj,
		String address,
		String phone
		) {
	 public SupplierDto(Supplier entity) {
	       this(
    		   entity.getId(),
    		   entity.getName(),
    		   entity.getCnpj(),
    		   entity.getAddress(),
    		   entity.getPhone()
    		   );
	       
	 }
	
}
