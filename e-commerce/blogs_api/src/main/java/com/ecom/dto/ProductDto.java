package com.ecom.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

	private String title;
	
	@Column(length = 100)
	private String description;
	
	private double price;
	
	private int quantity;
	
	private Long userId;
}
