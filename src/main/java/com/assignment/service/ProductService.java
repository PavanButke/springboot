package com.assignment.service;

import java.util.List;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;

public interface ProductService {

	public ProductDto getProduct(int productId);

	public List<ProductDto> getAllProducts();

	public ProductDto insertProduct(ProductDto productDto);

	public ProductDto updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);

	public List<Product> getByProductName(String productName);

	public List<Product> findByProductNameAndExpDate(String productName, String expDate);
	

}
