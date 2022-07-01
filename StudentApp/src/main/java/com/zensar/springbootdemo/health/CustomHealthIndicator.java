package com.zensar.springbootdemo.health;

import org.springframework.stereotype.Component;

import java.util.Random;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.boot.actuate.health.HealthIndicator;

@Component
public class CustomHealthIndicator extends AbstractHealthIndicator {

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {

		Random random = new Random();
		int randomNo = random.nextInt(100);
		if (randomNo % 2 == 0) {
			builder.up();
		} 
		else {
			    builder.down();
		}
	}
}

/*
 * public class CustomHealthIndicator implements HealthIndicator {
 * 
 * @Override public Health health() { int checkCode = 0;
 * 
 * if (checkCode != 0) { return Health.down().withDetail("Your System is Down",
 * checkCode).build(); } return Health.up().build(); }
 * 
 * }
 */