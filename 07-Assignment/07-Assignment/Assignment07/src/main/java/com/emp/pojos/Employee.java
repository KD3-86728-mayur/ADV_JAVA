package com.emp.pojos;

import java.time.LocalDate;

import org.hibernate.annotations.Collate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "emp_app")
@Entity
@ToString(callSuper = true)
public class Employee extends BaseEntity {

	@Column(length = 20, name="first_name")
	private String firstName;

	@Column(length = 20, name="last_name")
	private String lastName;
	
	@Column(length = 25, unique = true)
	private String email;

	@Column(length = 20, nullable = false)
	private String password;
	
	@Column(name="join_date")
	private LocalDate joinDate;
	
	@Column(length = 20)
	private String location;
	
	@Column(length = 20)
	private String department;
	
	private double salary;

}
