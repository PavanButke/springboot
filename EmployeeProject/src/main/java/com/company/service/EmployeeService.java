package com.company.service;

import java.util.List;

import com.company.entity.Employee;

public interface EmployeeService {
	
	public Employee getEmployee(int empId);

	public List<Employee> getAllEmployee();

	public void insertEmployee(Employee employee);

	public void updateEmployee(int empId , Employee employee);

	public void deleteEmployee(int empId);



}
