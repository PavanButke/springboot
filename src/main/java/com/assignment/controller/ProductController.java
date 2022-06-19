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

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;
import com.assignment.service.ProductService;

@RestController
@RequestMapping(value="/product-api",  produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE } , consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ProductController {

	// Let's add a new Layer --> Service Layer
	// Shift the list of Products into Service Layer
	// how to connect service layer to this ProductController?
	// Here is answer

//	private ProductService productService; 

	// now Autowire it
	// private ProductService productService;

	@Autowired
	private ProductService productService;

	// Writing Shorthands for @RequestMapping

	@GetMapping(value = "/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		return productService.getProduct(productId);

	}

	@GetMapping(value = { "/products", "listOfProducts" })
	public List<Product> getAllProducts() {

		return productService.getAllProducts();

	}
	
	@PostMapping(value = "products" )
	public void insertProduct(@RequestBody ProductDto productDto) {

		productService.insertProduct(productDto);

	}

	@PutMapping(value = "products/{productId}")
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody ProductDto productDto) {

		productService.updateProduct(productId, productDto);
	}

	@DeleteMapping("products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {

		productService.deleteProduct(productId);

	}

}
