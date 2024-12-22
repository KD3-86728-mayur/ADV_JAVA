package com.ecom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecom.dto.UserReqDto;
import com.ecom.service.UserServive;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserServive userService;

	@PostMapping
	public ResponseEntity<?> adduser(@RequestBody UserReqDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.addNewUser(userDto));
	}

	@GetMapping

	public ResponseEntity<?> displayProducts(@RequestParam Long userId) {
		return ResponseEntity.ok(userService.displayAllProducts(userId));
	}

}
