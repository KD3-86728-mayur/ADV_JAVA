package com.emp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.pojos.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
	List<Employee> findAll();

}
