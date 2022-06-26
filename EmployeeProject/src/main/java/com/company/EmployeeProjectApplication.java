package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

//when your packages are subpackage of main package where entry-class is declared then there is no need
// to use @ComponentScan , bCause @SpringBootApplication internally has @SpringBootConfiguration @EnableAutoConfiguration and @ComponentScan within it
//@ComponentScan(basePackages = {"com.company", "com.zensar"})
public class EmployeeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeProjectApplication.class, args);
	}

}
