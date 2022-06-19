package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void insertProduct(Product product) {

		productRepository.save(product);
	}

	@Override
	public void updateProduct(int productId, Product product) {

		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {

		productRepository.deleteById(productId);

	}
}
