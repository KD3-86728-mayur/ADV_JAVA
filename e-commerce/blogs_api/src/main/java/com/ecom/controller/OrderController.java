package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.OrderDto;
import com.ecom.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping
	public ResponseEntity<?> placeorder(@RequestBody OrderDto orderDto, @RequestParam int quantity) {

		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.placeNewOrder(orderDto, quantity));
	}

//	@PostMapping
//	public ResponseEntity<?> placeorder() {
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.placeNewOrder(orderDto));
//	}
}
