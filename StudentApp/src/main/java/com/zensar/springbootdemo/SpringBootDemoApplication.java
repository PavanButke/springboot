package com.zensar.springbootdemo;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"test","com.zensar"})
public class SpringBootDemoApplication extends SpringBootServletInitializer{

	public static void main(String... args) {
		System.out.println("Alpha");
		SpringApplication.run(SpringBootDemoApplication.class, args);
		
		System.out.println("Beta");
		
	}

		
	@Bean
	
	public ModelMapper modelMapper() {
		return new ModelMapper();
		
	}


	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return super.configure(builder);
	}


}
