package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Product;

@RestController
public class ProductController {

	List<Product> products = new ArrayList<Product>();

	public ProductController() {

		products.add(new Product(89, "Peanut Butter", "18May2023"));
		products.add(new Product(91, "Bread", "18May2022"));
		products.add(new Product(89, "Jam", "18March2022"));
	}

	@RequestMapping("/products/{productId}")
	
	
	public Product getProduct(@PathVariable("productId") int productId) {
		
		System.out.println("SS"+productId);
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}

		}
		return null;

	}

	@RequestMapping(value = { "/products", "/listOfProducts" }, method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return products;
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public void insertProduct(@RequestBody Product product) {
		products.add(product);

	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		Product newProduct = getProduct(productId);
		newProduct.setProductId(product.getProductId());
		newProduct.setProductName(product.getProductName());
		newProduct.setExpDate(product.getExpDate());

		products.add(newProduct);
	}

	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("productId") int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductId() == productId) {
				products.remove(product);
			}

		}
	}

//	@RequestMapping("/")
//	public String myMethod() {
//		return "\r\n"
//				+ "<style>\r\n"
//				+ "    body {\r\n"
//				+ "        background-color: skyblue;\r\n"
//				+ "    }\r\n"
//				+ "    div {\r\n"
//				+ "        height: 200px;\r\n"
//				+ "        margin: 20px;\r\n"
//				+ "        border: 5px solid;\r\n"
//				+ "        background-color: yellow;\r\n"
//				+ "    }\r\n"
//				+ "</style>\r\n"
//				+ "<body>\r\n"
//				+ "    <div>\r\n"
//				+ "        <p>Welcome to Spring Web Tutorile</p>\r\n"
//				+ "\r\n"
//				+ "        <div>\r\n"
//				+ "            <p>I am Pavan</p>\r\n"
//				+ "        </div>\r\n"
//				+ "    </div>\r\n"
//				+ "</body>";
//	}
//	
//	@RequestMapping("/check")
//	public String myMethod2() {
//		return "\r\n"
//				+ "<style>\r\n"
//				+ "    body {\r\n"
//				+ "        background-color: skyblue;\r\n"
//				+ "    }\r\n"
//				+ "    div {\r\n"
//				+ "        height: 200px;\r\n"
//				+ "        margin: 20px;\r\n"
//				+ "        border: 5px solid;\r\n"
//				+ "        background-color: yellow;\r\n"
//				+ "    }\r\n"
//				+ "</style>\r\n"
//				+ "<body>\r\n"
//				+ "    <div>\r\n"
//				+ "        <p>Welcome to Spring Web Tutorile</p>\r\n"
//				+ "\r\n"
//				+ "        <div>\r\n"
//				+ "            <p>I am Pavan</p>\r\n"
//				+ "        </div>\r\n"
//				+ "    </div>\r\n"
//				+ "</body>";
//		
//	}
}
