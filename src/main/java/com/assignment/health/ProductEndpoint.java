package com.assignment.health;



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
public class ProductEndpoint {
	

	private Map<String, List<String>> products = new HashMap<>();

	@PostConstruct
	public void init() {
		products.put("Poco M14", Arrays.asList("Congrats!", "You have Won of Poco M14."));
		
	}

	@ReadOperation
	public Map<String, List<String>> getAllProducts() {
		return this.products;
	}

	@ReadOperation
	public List<String> getAllProductsByCode(@Selector String code) {
		return this.products.get(code);
	}

	@WriteOperation
	public void addCopouns(@Selector String code, @Selector String benifit) {
		products.put(code, Arrays.asList(benifit.split(",")));
	}

	@DeleteOperation
	public void deleteCopouns(@Selector String code) {
		products.remove(code);
	}
}


