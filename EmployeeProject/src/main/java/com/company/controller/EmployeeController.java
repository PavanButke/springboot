package com.company.controller;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.dto.EmployeeDto;
import com.company.entity.Employee;
import com.company.service.EmployeeService;

@RestController
@RequestMapping("/employee-api")
//RequestMapping which is again unnecessary , but it can act as unique identifier URL
public class EmployeeController {

	//cleaning up the static data
	
	@Autowired
	private EmployeeService employeeService;
	
// Now let's implement the concept of Content Negotiation
// Let's say I want data in the form of XML or I want send in the XML form 	along with JSON as well	
	@GetMapping(value = "/employees/{empId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
//	produces --> Means returning back data to console or o/p	
	// @RequestMapping(value="/employees/{empId}" , method=RequestMethod.GET)
	public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("empId") int empId) {
		
		return new ResponseEntity<EmployeeDto>(employeeService.getEmployee(empId), HttpStatus.OK);

	}

	// we can use GetMapping , PostMapping... and so on AS SHORTHAND FOR
	// REQUESTMAPPING , WE can reduce code using that
	@GetMapping(value="/employees", produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} )
		//@RequestMapping(value = {"/employees" , "listOfEmployees"} , method = RequestMethod.GET)
		public List<EmployeeDto> getAllEmployee(){
			return employeeService.getAllEmployee();
		}

	// consumes means taking input from user
	@PostMapping(value = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// @RequestMapping(value = "/employees" , method = RequestMethod.POST)
	public ResponseEntity<EmployeeDto> insertEmployee(@RequestBody EmployeeDto employeeDto) {
		
		return new ResponseEntity<EmployeeDto>(employeeService.insertEmployee(employeeDto), HttpStatus.CREATED) ;
	}

	@PutMapping(value = "/employees/{empId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	// @RequestMapping(value="/employees/{empId}", method = RequestMethod.PUT)
	public ResponseEntity<String> updateEmployee(@PathVariable("empId") int empId, @RequestBody EmployeeDto employeeDto) {

		
		 employeeService.updateEmployee(empId, employeeDto);
		 
		   return new ResponseEntity<String>("Tada ! You updated an Employee Record ",HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/employees/{empId}")
	// @RequestMapping(value= "/employees/{empId}", method = RequestMethod.DELETE )
	public ResponseEntity<String> deleteEmployee(@PathVariable("empId") int empId) {

		employeeService.deleteEmployee(empId);
		
		return new ResponseEntity<String>("Oops ! You deleted an Employee Record", HttpStatus.OK);
		}

	}

