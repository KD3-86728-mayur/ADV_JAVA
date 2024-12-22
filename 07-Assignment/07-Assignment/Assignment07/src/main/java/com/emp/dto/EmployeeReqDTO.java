package com.emp.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeReqDTO {

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private LocalDate joinDate;

	private String location;

	private String department;

	private double salary;
}
