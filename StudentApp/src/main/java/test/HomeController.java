package test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	// http://localhost:8080/
	@RequestMapping("/")
	public String sayHello() {
		return "<h2> Welcome to Spring Boot </h2>";
	}
	
	
	
	

}
