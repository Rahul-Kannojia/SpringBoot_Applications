package com.app.product.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		boolean error = false;
		if(error) {
			return Health.down().withDetail("Error Key",123).build();
		}
		return Health.up().build();
	}

}
