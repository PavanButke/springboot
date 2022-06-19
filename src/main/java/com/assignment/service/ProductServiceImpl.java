package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.assignment.entity.Product;

@Service
public class ProductServiceImpl  implements ProductService {
	
	List<Product> products = new ArrayList<Product>();

	public ProductServiceImpl() {

		products.add(new Product(89, "Peanut Butter", "18May2023"));
		products.add(new Product(91, "Bread", "18May2022"));
		products.add(new Product(89, "Jam", "18March2022"));
	}

	@Override
	public Product getProduct(int productId) {
		
		for (Product product : products) {
			if (product.getProductId() == productId) {
				return product;
			}

		}

		
		return null;
	}

	
	@Override
	public List<Product> getAllProducts() {
		return products;
	
	}
	

	@Override
	public void insertProduct(Product product) {
		products.add(product);
	}
	
	
	

	@Override
	public void updateProduct(int productId, Product product) {
		
			Product newProduct = getProduct(productId);
			newProduct.setProductId(product.getProductId());
			newProduct.setProductName(product.getProductName());
			newProduct.setExpDate(product.getExpDate());
			
			products.add(newProduct);

	}


	@Override
	public void deleteProduct(int productId) {
		for (int i = 0; i < products.size(); i++) {
			Product product = products.get(i);
			if (product.getProductId() == productId) {
				products.remove(product);
			}

	}

	}
}

	

