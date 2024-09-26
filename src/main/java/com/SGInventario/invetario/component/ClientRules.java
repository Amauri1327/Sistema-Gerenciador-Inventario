package com.SGInventario.invetario.component;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.SGInventario.invetario.dto.ProductSummaryDto;
import com.SGInventario.invetario.dto.ReportClientDto;
import com.SGInventario.invetario.entities.Client;

@Component
public class ClientRules {

	public ReportClientDto generateClientReport(Client client) {
		
		List<ProductSummaryDto> productSummaries = client.getProducts().stream()
				.map(product -> new ProductSummaryDto(product.getId(), product.getName(), product.getPrice()))
				.collect(Collectors.toList());
		
		return new ReportClientDto(
				client.getId(), 
				client.getName(), 
				client.getPhone(), 
				productSummaries);
		
	}
}
