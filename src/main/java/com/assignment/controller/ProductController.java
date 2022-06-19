package com.assignment.controller;

import java.util.ArrayList;
import java.util.List;

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

@RestController
public class ProductController {

	List<Product> products = new ArrayList<Product>();

	public ProductController() {

		products.add(new Product(89, "Peanut Butter", "18May2023"));
		products.add(new Product(91, "Bread", "18May2022"));
		products.add(new Product(89, "Jam", "18March2022"));
	}
	 // Writing Shorthands for @RequestMapping
	//@RequestMapping(value="/products/{productId}",  method = RequestMethod.GET)
	@GetMapping(value="/products/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		
		
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}

		}
		return null;

	}

//	@RequestMapping(value = { "/products", "/listOfProducts" }, method = RequestMethod.GET)
	@GetMapping(value={"/products" , "listOfProducts"})
	public List<Product> getAllProducts() {
		return products;
	}

//	@RequestMapping(value = "/products", method = RequestMethod.POST)
	@PostMapping(value="products")
	public void insertProduct(@RequestBody Product product) {
		products.add(product);

	}

//	@RequestMapping(value = "/products/{productId}", method = RequestMethod.PUT)
	@PutMapping(value = "products/{productId}")
	public void updateProduct(@PathVariable("productId") int productId, @RequestBody Product product) {
		Product newProduct = getProduct(productId);
		newProduct.setProductId(product.getProductId());
		newProduct.setProductName(product.getProductName());
		newProduct.setExpDate(product.getExpDate());

		products.add(newProduct);
	}

//	@RequestMapping(value = "/products/{productId}", method = RequestMethod.DELETE)
	@DeleteMapping("products/{productId}")
	public void deleteProduct(@PathVariable("productId") int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductId() == productId) {
				products.remove(product);
			}

		}
	}



}
