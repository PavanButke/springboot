package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;
import com.assignment.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProductDto getProduct(int productId) {
		Product product= productRepository.findById(productId).get();

		
		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> productList = productRepository.findAll();

		List<ProductDto> productListDto = new ArrayList<ProductDto>();
		for(Product product: productList) {
				productListDto.add(modelMapper.map(product, ProductDto.class));	
		}

		return productListDto;
	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {
		
	
		
		Product product = modelMapper.map(productDto,Product.class);
		
		Product newProduct = productRepository.save(product);
	
		return 	modelMapper.map(newProduct, ProductDto.class);
		 
		
		
	}

	@Override
	public ProductDto updateProduct(int productId, ProductDto productDto) {
		
		Product product = modelMapper.map(productDto,Product.class);
		
		 productRepository.save(product);
		
		return productDto;
	
	}

	@Override
	public void deleteProduct(int productId) {

		productRepository.deleteById(productId);

	}

	@Override
	public List<Product> getByProductName(String productName) {
	
		return productRepository.checking(productName);
	}

	@Override
	public List<Product> findByProductNameAndExpDate(String productName, String expDate) {
		
		return productRepository.checking101(productName , expDate);
	}
	
	


}
