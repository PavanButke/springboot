package com.company.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@RequestMapping("/")
	public String methodCheck() {
		return "<h3>hasta la vista</h3>";
	}
	
	@RequestMapping("/next")
	public String methodCheck2(){
		return "<h2>Hands On Practice</h2>";
	}
	
}
