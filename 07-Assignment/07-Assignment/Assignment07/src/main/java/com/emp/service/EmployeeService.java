package com.emp.service;

import java.util.List;

import com.emp.dto.ApiResponse;
import com.emp.pojos.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployee();
	String addNewEmployee(Employee employee);
	ApiResponse deleteEmployee(Long Id);
	ApiResponse updateEmployee(Long Id, Employee employee);
}
