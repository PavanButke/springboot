package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.company.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	// Creating an Static List of Employee Data
	List<Employee> employees = new ArrayList<Employee>();
	// constructor of List

	public EmployeeServiceImpl() {
		employees.add(new Employee(19, "Alpha", "Development"));
		employees.add(new Employee(29, "Beta", "Development"));
		employees.add(new Employee(19, "Sigma", "HR"));
		employees.add(new Employee(19, "Gamma", "Training"));
	}
	
	
	@Override
	public Employee getEmployee(int empId) {
		for (Employee employee : employees) {

			if (employee.getEmpId() == empId)

				return employee;
		}

		return null;
	}


	@Override
	public List<Employee> getAllEmployee() {
		return employees;
		
	}


	@Override
	public void insertEmployee(Employee employee) {
		employees.add(employee);
		
	}


	@Override
	public void updateEmployee(int empId, Employee employee) {
		
		Employee newEmp = getEmployee(empId);
		newEmp.setEmpDept(employee.getEmpDept());
		newEmp.setEmpName(employee.getEmpName());
		newEmp.setEmpId(employee.getEmpId());
		
		employees.add(newEmp);
		
	}


	@Override
	public void deleteEmployee(int empId) {
		
		for(int i=0 ; i<employees.size() ; i++) {
			Employee employee = employees.get(i);
			
			if(employee.getEmpId()== empId) {
				employees.remove(employee);
			}
		}
		
	}


	

}
