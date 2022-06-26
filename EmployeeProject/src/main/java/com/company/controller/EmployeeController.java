package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public Employee getEmployee(@PathVariable("empId") int empId) {

		return employeeService.getEmployee(empId);

	}

	// we can use GetMapping , PostMapping... and so on AS SHORTHAND FOR
	// REQUESTMAPPING , WE can reduce code using that
	@GetMapping(value="/employees", produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} )
		//@RequestMapping(value = {"/employees" , "listOfEmployees"} , method = RequestMethod.GET)
		public List<Employee> getAllEmployee(){
			return employeeService.getAllEmployee();
		}

	// consumes means taking input from user
	@PostMapping(value = "/employees", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	// @RequestMapping(value = "/employees" , method = RequestMethod.POST)
	public void insertEmployee(@RequestBody Employee employee) {
		employeeService.insertEmployee(employee);
	}

	@PostMapping(value = "/employees/{empId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	// @RequestMapping(value="/employees/{empId}", method = RequestMethod.PUT)
	public void updateEmployee(@PathVariable("empId") int empId, @RequestBody Employee employee) {

		employeeService.updateEmployee(empId, employee);
	}

	@DeleteMapping(value = "/employees/{empId}")
	// @RequestMapping(value= "/employees/{empId}", method = RequestMethod.DELETE )
	public void deleteEmployee(@PathVariable("empId") int empId) {

		employeeService.deleteEmployee(empId);
		}

	}

