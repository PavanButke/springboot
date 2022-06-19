package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;
import com.assignment.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product getProduct(int productId) {
		return productRepository.findById(productId).get();

	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();

	}

	@Override
	public Product insertProduct(ProductDto productDto) {
		
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setExpDate(productDto.getExpDate());
		
		return productRepository.save(product);
		
	}

	@Override
	public Product updateProduct(int productId, ProductDto productDto) {
		
		Product product = new Product();
		product.setProductId(productDto.getProductId());
		product.setProductName(productDto.getProductName());
		product.setExpDate(productDto.getExpDate());
		return productRepository.save(product);
	
	}

	@Override
	public void deleteProduct(int productId) {

		productRepository.deleteById(productId);

	}



	
}
