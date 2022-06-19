package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.entity.Product;
import com.assignment.service.ProductService;

@RestController
public class ProductController {

	// Let's add a new Layer --> Service Layer
	// Shift the list of Products into Service Layer
	//how to connect service layer to this ProductController?
	//Here is answer
	
//	private ProductService productService; 
	
	// now Autowire it
	//private ProductService productService; 
	
	@Autowired
	private ProductService productService; 
	
	// Writing Shorthands for @RequestMapping

	@GetMapping(value = "/products/{productId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Product getProduct(@PathVariable("productId") int productId) {
		return productService.getProduct(productId);
	

		
		
	}

	@GetMapping(value = { "/products", "listOfProducts" }, produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
		public List<Product> getAllProducts() {
		
		return  productService.getAllProducts();
				
	}

	@PostMapping(value = "products", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void insertProduct(@RequestBody Product product) {
		
			productService.insertProduct(product);

	}

	@PutMapping(value = "products/{productId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {

		productService.updateProduct(productId, product );
	}

	@DeleteMapping("products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {

		productService.deleteProduct(productId);
	
	}

}
