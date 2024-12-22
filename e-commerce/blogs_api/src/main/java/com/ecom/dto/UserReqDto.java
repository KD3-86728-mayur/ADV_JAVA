package com.ecom.dto;

import com.ecom.pojos.UserRole;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDto {

	private String name;

	private String email;

	private String password;

	private UserRole role;
}
