package com.company.service;

import java.util.List;

import com.company.dto.EmployeeDto;
import com.company.entity.Employee;

public interface EmployeeService {
	
	public EmployeeDto getEmployee(int empId);

	public List<EmployeeDto> getAllEmployee();


	public void deleteEmployee(int empId);

	public EmployeeDto insertEmployee(EmployeeDto employeeDto);

	public Employee updateEmployee(int empId, EmployeeDto employeeDto);



}
