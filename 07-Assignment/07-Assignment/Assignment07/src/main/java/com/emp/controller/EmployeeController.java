package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.dto.ApiResponse;
import com.emp.pojos.Employee;
import com.emp.service.EmployeeService;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	public EmployeeController() {
		System.out.println("In Constructor" + getClass());
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllEmpDetails() {
		System.out.println("Get all employee");
		List<Employee> employee = employeeService.getAllEmployee();
		if (employee.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(employee);
	}

	@PostMapping("/")
	public ResponseEntity<?> addNewCategory(@RequestBody Employee employee) {
		System.out.println("In add employee list " + employee);// transient category
		return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addNewEmployee(employee));
	}

	@DeleteMapping
	public ResponseEntity<?> deleteEmpDetails(@RequestParam() Long empId) {
		System.out.println(" " + empId);
		try {
			return ResponseEntity.ok(employeeService.deleteEmployee(empId));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse());
		}
	}
	
	@PutMapping("/{empId}")
	public ResponseEntity<?> updateEmployeeDetails(@PathVariable Long empId, @RequestBody Employee employee) {
		System.out.println("In update employee: " + empId);
		
		return ResponseEntity.ok(employeeService.updateEmployee(empId, employee));
	}
}
