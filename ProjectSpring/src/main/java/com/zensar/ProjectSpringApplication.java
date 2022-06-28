package com.zensar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
public class ProjectSpringApplication {

	public static void main(String[] args) {
		System.out.println("First");
		SpringApplication.run(ProjectSpringApplication.class, args);
		System.out.println("Last");
	}

}
