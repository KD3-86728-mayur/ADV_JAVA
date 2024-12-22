package com.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

	private double bill;
	private Long userId;
	private Long productId;
}
