package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.custom_exception.ResourceNotFoundException;
import com.emp.dao.EmployeeDao;
import com.emp.dto.ApiResponse;
import com.emp.pojos.Employee;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployee() {
		return employeeDao.findAll();
	}

	@Override
	public String addNewEmployee(Employee employee) {
		employeeDao.save(employee);
		return "Added new employee with ID";
	}
	
	@Override
	public ApiResponse deleteEmployee(Long empId) {
		
		if(employeeDao.existsById(empId))
		{
			employeeDao.deleteById(empId);
			return new ApiResponse("Deleted Employee Details");
		}
		throw new ResourceNotFoundException("Invalid Employee Id !!!!");
	}

	@Override
	public ApiResponse updateEmployee(Long empId, Employee employee) {
		if(employeeDao.existsById(empId))
		{
			employee.setId(empId);
			employeeDao.save(employee);
			return new ApiResponse("Employee updated");
		}
		return new ApiResponse("Invalid Employee ID !!!!");
	}
}
