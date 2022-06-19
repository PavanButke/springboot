package com.assignment.service;

import java.util.List;

import com.assignment.entity.Product;

public interface ProductService {

	 public Product getProduct(int productId);

	 public List<Product> getAllProducts();

	public void insertProduct(Product product);
	public void updateProduct(int productId, Product product);
	

	public void deleteProduct(int productId);



	
	
	

}
