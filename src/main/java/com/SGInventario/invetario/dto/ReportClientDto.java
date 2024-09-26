package com.SGInventario.invetario.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportClientDto {

	private Long id; 
	private String name;
    private String phone;
    private List<ProductSummaryDto> products;
    
    
    public ReportClientDto(Long id, String name, String phone, List<ProductSummaryDto> products) {
    	this.id = id;
    	this.name = name;
    	this.phone = phone;
    	this.products = products;
    }
    
}
