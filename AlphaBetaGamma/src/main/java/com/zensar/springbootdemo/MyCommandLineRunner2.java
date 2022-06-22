package com.zensar.springbootdemo;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyCommandLineRunner2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		System.out.println("MyCommandLineRunner2 "+Arrays.toString(args));
		
	} 

}
