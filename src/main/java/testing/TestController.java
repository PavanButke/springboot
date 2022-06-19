package testing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


		
	
		@RequestMapping("/")
		public String CheckOneTwo() {
			return "<h2> Mic Check 1 2 1 </h2>";
		}
		
		
		
		
		
}
