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
//		ProductDto dto = mapToDto(product);	
//		return dto;
		
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
		
		//Product product = mapToEntity(productDto);
		
		Product product = modelMapper.map(productDto,Product.class);
		
		Product newProduct = productRepository.save(product);
//	
//		ProductDto dto = mapToDto(newProduct);
//		
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
		// TODO Auto-generated method stub
		return productRepository.getByProductName(productName);
	}

//	public ProductDto mapToDto(Product product) {
//		
//		ProductDto dto = new ProductDto();
//		dto.setProductId(product.getProductId());
//		dto.setProductName(product.getProductName());
//		dto.setExpDate(product.getExpDate());
//		
//		return dto;
//		
//	}
//	
//	
//	public Product mapToEntity(ProductDto productDto) {
//		
//		Product product = new Product();
//		product.setProductId(productDto.getProductId());
//		product.setProductName(productDto.getProductName());
//		product.setExpDate(productDto.getExpDate());
//		return product;
//	
//	}
}
