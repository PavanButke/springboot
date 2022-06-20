package com.assignment;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "testing", "com.assignment" })
public class ProductServiceApplication {

	public static void main(String... args) {
		System.out.println("Let's Get Started");

		SpringApplication.run(ProductServiceApplication.class, args);

		System.out.println("Bhetu");
	}

	
	@Bean

	public ModelMapper modelMapper() {
		return new ModelMapper();

	}
}
