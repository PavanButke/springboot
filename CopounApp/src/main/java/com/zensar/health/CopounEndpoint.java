package com.zensar.health;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "copoun-endpoint")
public class CopounEndpoint {
	

	private Map<String, List<String>> copouns = new HashMap<>();

	@PostConstruct
	public void init() {
		copouns.put("Hungry101", Arrays.asList("Congrats!", "You have offer of Rs.101 off on your next meal."));
		
	}

	@ReadOperation
	public Map<String, List<String>> getAllCopouns() {
		return this.copouns;
	}

	@ReadOperation
	public List<String> getAllCopounsByCode(@Selector String code) {
		return this.copouns.get(code);
	}

	@WriteOperation
	public void addCopouns(@Selector String code, @Selector String benifit) {
		copouns.put(code, Arrays.asList(benifit.split(",")));
	}

	@DeleteOperation
	public void deleteCopouns(@Selector String code) {
		copouns.remove(code);
	}
}


