package com.SGInventario.invetario.component;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.SGInventario.invetario.dto.ProductDto;
import com.SGInventario.invetario.entities.Product;

@Component
public class ProductRules {

	public List<ProductDto> generateProductReport(List<Product> products){
		
		return products.stream()
		.map(product -> {
			String supplierName = product.getSupplierName();
			 return new ProductDto(
	                    product.getId(),
	                    product.getName(),
	                    product.getDescription(),
	                    product.getPrice(),
	                    product.getQuantity(),
	                    product.getCategory(),
	                    product.getMaxStock(),
	                    product.getMinStock(),
	                    supplierName
	                );
		}).collect(Collectors.toList());
		
	}
	
}
