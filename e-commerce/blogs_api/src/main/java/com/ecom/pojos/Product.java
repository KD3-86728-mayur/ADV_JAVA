package com.ecom.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product extends BaseClass {

	@Column(length = 30 , nullable = false)
	private String title;
	
	@Column(length = 100)
	private String description;
	
	private double price;
	
	private int quantity;
	
	private int status;
}
