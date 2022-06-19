package com.assignment;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

public class ProductCommandLineRunner2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		System.out.println("I'm Inside ProductCommandLineRunner 2nd"+Arrays.toString(args)) ;
		
	}

	
	

	
	
}
