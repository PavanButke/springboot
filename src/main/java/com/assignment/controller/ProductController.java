package com.assignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	
	public String myMethod() {
		return "\r\n"
				+ "<style>\r\n"
				+ "    body {\r\n"
				+ "        background-color: skyblue;\r\n"
				+ "    }\r\n"
				+ "    div {\r\n"
				+ "        height: 200px;\r\n"
				+ "        margin: 20px;\r\n"
				+ "        border: 5px solid;\r\n"
				+ "        background-color: yellow;\r\n"
				+ "    }\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "    <div>\r\n"
				+ "        <p>Welcome to Spring Web Tutorile</p>\r\n"
				+ "\r\n"
				+ "        <div>\r\n"
				+ "            <p>I am Pavan</p>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</body>";
	}
	
	@RequestMapping("/check")
	public String myMethod2() {
		return "\r\n"
				+ "<style>\r\n"
				+ "    body {\r\n"
				+ "        background-color: skyblue;\r\n"
				+ "    }\r\n"
				+ "    div {\r\n"
				+ "        height: 200px;\r\n"
				+ "        margin: 20px;\r\n"
				+ "        border: 5px solid;\r\n"
				+ "        background-color: yellow;\r\n"
				+ "    }\r\n"
				+ "</style>\r\n"
				+ "<body>\r\n"
				+ "    <div>\r\n"
				+ "        <p>Welcome to Spring Web Tutorile</p>\r\n"
				+ "\r\n"
				+ "        <div>\r\n"
				+ "            <p>I am Pavan</p>\r\n"
				+ "        </div>\r\n"
				+ "    </div>\r\n"
				+ "</body>";
		
	}
}
