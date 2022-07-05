package com.zensar.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LandingAuth {

	@GetMapping("/encrypted")
	public String welcome() {
		String text = "You need Permission to Enter ";
		text += "Kindly Verify your Identity";
		return text;
	}
}