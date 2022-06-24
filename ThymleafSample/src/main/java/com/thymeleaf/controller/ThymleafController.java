package com.thymeleaf.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ThymleafController {

	@Value("${LandingPage.message}")
	String message;

	private List<String> companies = Arrays.asList("Zensar", "CEAT", "RPG");

	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("message", message);
		model.addAttribute("companies", companies);

		return "LandingPage";
	}

	@GetMapping("/main")
	public String mainWithParam(@RequestParam(name = "Customer", required = false , defaultValue = "") String name, Model model) {

		model.addAttribute("message", name);
		model.addAttribute("companies", companies);

		return "LandingPage";
	}
}
