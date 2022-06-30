package com.assignment.health;



import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;

import org.springframework.stereotype.Component;

@Component
public class SysHealthCheck extends AbstractHealthIndicator {


	    @Override
	    protected void doHealthCheck(Health.Builder builder) {
	        int number = getRandomNumber();

	        if (number != 0) {
	            builder.up().build();
	        } else {
	            builder.down().withDetail("Oops ! Error Occured", "This is a Zero").build();
	        }
	    }

	    private int getRandomNumber() {
	        return new Random().ints(0,2).findFirst().orElseThrow(() -> new RuntimeException("Failed to generate random number"));
	    }
}


