package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.ProductDto;
import com.ecom.service.ProductService;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<?> addProduct(@RequestBody ProductDto productDto) {

		return ResponseEntity.status(HttpStatus.CREATED).body(productService.addNewProduct(productDto));

	}

	@GetMapping
	public ResponseEntity<?> deleteProduct(@RequestParam Long productId, @RequestParam Long userId) {

		return ResponseEntity.status(HttpStatus.OK).body(productService.softDelete(productId , userId));

	}
}
