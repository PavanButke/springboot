package com.assignment.service;

import java.util.List;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;

public interface ProductService {

	public Product getProduct(int productId);

	public List<Product> getAllProducts();

	public Product insertProduct(ProductDto productDto);

	public Product updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);

	

}
