package com.zensar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zensar.entity.Coupon;
import com.zensar.entity.Product;
import com.zensar.restclient.CouponRestClient;
import com.zensar.services.ProductService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private CouponRestClient restClient;

	@PostMapping("/")
	@Retry(name = "productapi",fallbackMethod = "myFallbackMethod")
	public Product insertProduct(@RequestBody Product product) {
		Coupon coupon = restClient.getCoupon(product.getCouponCode());
		
		Double discount = coupon.getDiscount();
		
		product.setPrice(product.getPrice()- discount);
		
		return productService.insertProduct(product);
	}
	

	public Product myFallbackMethod(Throwable t) {
		return new Product();
	}

}
