package com.SGInventario.invetario.dto;

import com.SGInventario.invetario.entities.Product;

public record ProductDto(
		Long id,
		String name,
		String description,
		Double price,
		Integer quantity,
		String category,
		Integer maxStock,
		Integer minStock,
		String supplierName
		) {
	
	public ProductDto(Product entity) {
		this(
			entity.getId(),
			entity.getName(),
			entity.getDescription(),
			entity.getPrice(),
			entity.getQuantity(),
			entity.getCategory(),
			entity.getMaxStock(),
			entity.getMinStock(),
			entity.getSupplierName()
			);
	}

}
