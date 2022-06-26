package com.company.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.dto.EmployeeDto;
import com.company.entity.Employee;

import com.company.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public EmployeeDto getEmployee(int empId) {
		
		Employee employee = employeeRepository.findById(empId).get();
//		EmployeeDto dto = mapToDto(employee);
		return modelMapper.map(employee, EmployeeDto.class) ;
	}


	@Override
	public List<EmployeeDto> getAllEmployee() {
		
		List<Employee> employeeList = employeeRepository.findAll();
		
		List<EmployeeDto> employeeDtoList = new ArrayList<EmployeeDto>();
		for(Employee employee : employeeList) {
				
			employeeDtoList.add(modelMapper.map(employee, EmployeeDto.class));
		}
		return employeeDtoList;
	}


	@Override
	public EmployeeDto insertEmployee(EmployeeDto employeeDto) {
	

//		Employee newEmp = mapToEntity(employeeDto);
//		
//		Employee intern = employeeRepository.save(newEmp);
//		
//		EmployeeDto dto = mapToDto(intern);
//		return dto;
		
		Employee employee = modelMapper.map(employeeDto, Employee.class);
		
		Employee newEmp = employeeRepository.save(employee);
		
		return modelMapper.map(newEmp, EmployeeDto.class);
		
	}


	@Override
	public EmployeeDto updateEmployee(int empId, EmployeeDto employeeDto) {
		
//		Employee newEmp = mapToEntity(employeeDto);
		Employee newEmp = modelMapper.map(employeeDto, Employee.class);
		
		employeeRepository.save(newEmp);
		
	
		return employeeDto;
		
	}


	@Override
	public void deleteEmployee(int empId) {
		
		employeeRepository.deleteById(empId);
		
	}
	
	
//	public EmployeeDto mapToDto(Employee employee) {
//		
//		EmployeeDto dto = new EmployeeDto();
//		
//		dto.setEmpId(employee.getEmpId());
//		dto.setEmpName(employee.getEmpName());
//		dto.setEmpDept(employee.getEmpDept());
//		return dto;
//		
//	}
//
//	
//	public Employee mapToEntity(EmployeeDto employeeDto) {
//		
//
//		Employee newEmp = new Employee();
//		newEmp.setEmpDept(employeeDto.getEmpDept());
//		newEmp.setEmpName(employeeDto.getEmpName());
//		newEmp.setEmpId(employeeDto.getEmpId());
//		
//		return newEmp;
//		
//	}

	

}
