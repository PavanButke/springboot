package com.assignment;

import java.util.Arrays;


import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ProductApplicationRunner implements ApplicationRunner {

	

	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Hey my Application Runner is Running"+ Arrays.toString(args.getSourceArgs()));
	}

}