package com.SGInventario.invetario.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductSummaryDto {

	private Long id;
	private String name;
	private Double price;
	
	
	public ProductSummaryDto(Long id, String name, Double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
}
