package com.emp.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true)

public class EmployeeRespDTO extends BaseDTO {

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private LocalDate joinDate;

	private String location;

	private String department;

	private double salary;
}
