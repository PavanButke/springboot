package com.zensar.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	 @Autowired
	 RestTemplate restTemplate;
	 
//	 @GetMapping("/products/{productId}")
//		public Product getProduct(@PathVariable("productId") int productId) {
//			return productService.getProduct(productId);		
//		}
	
	@PostMapping("/")
	public Product insertProduct(@RequestBody Product product) {
		
		
	 	 ResponseEntity<Coupon> coupon = restTemplate.getForEntity("http://localhost:8083/coupons/"+product.getCouponCode(), Coupon.class);
	 	 
	 	 
	 	 Coupon copounObj = coupon.getBody();
	 	 

	 
	 	 product.setPrice(product.getPrice() - copounObj.getDiscount() ); 
		
	 	 return productService.insertProduct(product);
	}

	//	@DeleteMapping("/products/{productId}")
	//	public Product deleteProduct(@PathVariable("productId") int productId) {
	//		return productService.deleteProduct(productId);		
	//	}
	
}


