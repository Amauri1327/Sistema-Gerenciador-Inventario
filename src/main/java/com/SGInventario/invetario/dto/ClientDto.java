package com.SGInventario.invetario.dto;

import com.SGInventario.invetario.entities.Client;

public record ClientDto(
		Long id,
		String name,
		String cpf,
		String address,
		String phone
		
		) {
	 public ClientDto(Client entity) {
	       this(
    		   entity.getId(),
    		   entity.getName(),
    		   entity.getCpf(),
    		   entity.getAddress(),
    		   entity.getPhone()
    		   );
	 }
	
}
