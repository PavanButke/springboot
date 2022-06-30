package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;
import com.assignment.service.ProductService;

@RestController
@RequestMapping(value = "/product-api")
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
	public ResponseEntity<ProductDto> getProduct(@PathVariable("productId") int productId) {

		
		return new ResponseEntity<ProductDto>(productService.getProduct(productId), HttpStatus.OK);
		
	}

	@GetMapping(value = { "/products", "listOfProducts" })
	public ResponseEntity<List<ProductDto>> getAllProducts(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "3") int pageSize,
			@RequestParam(value = "order", required = false, defaultValue = "true") boolean order,
			@RequestParam(value = "sort", required = false, defaultValue = "productName") String... properties) {

		return new ResponseEntity<List<ProductDto>>(
				productService.getAllProducts(pageNumber, pageSize, order, properties), HttpStatus.OK);

	}

	@PostMapping(value = "products")
	public ResponseEntity<ProductDto> insertProduct(@RequestBody ProductDto productDto) {

		return new ResponseEntity<ProductDto>(productService.insertProduct(productDto), HttpStatus.CREATED);

	}

	@PutMapping(value = "products/{productId}")
	public ResponseEntity<String> updateProduct(@PathVariable("productId") int productId,
			@RequestBody ProductDto productDto) {

		productService.updateProduct(productId, productDto);
		return new ResponseEntity<String>("Tada ! You updated an Product ", HttpStatus.CREATED);
	}

	@DeleteMapping("products/{productId}")
	public ResponseEntity<String> deleteProduct(@PathVariable("productId") int productId) {

		productService.deleteProduct(productId);
		return new ResponseEntity<String>("Oops ! You deleted an Product", HttpStatus.OK);

	}

	@GetMapping("/products/list/{productName}")
	public ResponseEntity<List<ProductDto>> getByProductName(@PathVariable("productName") String productName) {

		return new ResponseEntity<List<ProductDto>>(productService.getByProductName(productName), HttpStatus.OK);

	}

	@GetMapping("/products/{productName}/{expDate}")
	public ResponseEntity<List<ProductDto>> findByProductNameAndExpDate(@PathVariable("productName") String productName,
			@PathVariable("expDate") String expDate) {

		return new ResponseEntity<List<ProductDto>>(productService.findByProductNameAndExpDate(productName, expDate),
				HttpStatus.OK);
	}

}
