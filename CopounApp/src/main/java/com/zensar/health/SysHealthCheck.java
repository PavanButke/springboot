package com.zensar.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class SysHealthCheck implements HealthIndicator {
	
	@Override
	public Health health() {
		int checkCode = 0;

		if (checkCode != 0) {
			return Health.down().withDetail("Your System is Down", checkCode).build();
		}
		return Health.up().build();
	}

}
