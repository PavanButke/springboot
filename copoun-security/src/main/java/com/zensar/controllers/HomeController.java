package com.zensar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notsecure")
public class HomeController {
	
	
	@GetMapping("/line")
	public String getLine() {
		return "This is Line-------";
		
	}
	
	@GetMapping("/dots")
	public String getDots() {
		return "This are Dot ......";
		
	}


}
