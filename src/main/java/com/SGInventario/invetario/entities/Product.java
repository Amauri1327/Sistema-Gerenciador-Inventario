package com.SGInventario.invetario.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name="tb_product")
public class Product implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String description;
	private Double price;
	private Integer quantity;
	private String category;
	private Integer maxStock;
	private Integer minStock;
	
	@ManyToMany(mappedBy = "products")
	@Setter
	@JsonIgnore
	private Set<Client> clients = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Supplier supplier;
	
	public String getSupplierName() {
		return supplier.getName();
	}
}
