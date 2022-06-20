package com.assignment.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;

public interface ProductService {

	public ProductDto getProduct(int productId);

	public ProductDto insertProduct(ProductDto productDto);

	public ProductDto updateProduct(int productId, ProductDto productDto);

	public void deleteProduct(int productId);

	public List<ProductDto> getByProductName(String productName);

	public List<ProductDto> findByProductNameAndExpDate(String productName, String expDate);

	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, boolean order, String... properties);

}
