package com.assignment.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
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
	public ProductDto getProduct(int productId) throws OpenApiResourceNotFoundException {
		Product product = productRepository.findById(productId).get();

		return modelMapper.map(product, ProductDto.class);
	}

	@Override
	public List<ProductDto> getAllProducts(int pageNumber, int pageSize, boolean order, String... properties) {


		List<ProductDto> productListDto = new ArrayList<ProductDto>();

		Page<Product> listOfProduct = productRepository
				.findAll(PageRequest.of(pageNumber, pageSize, order ? Direction.ASC : Direction.DESC, properties));
		List<Product> content = listOfProduct.getContent();
		for (Product product : content) {
			productListDto.add(modelMapper.map(product, ProductDto.class));
		}

		return productListDto;
	}

	@Override
	public ProductDto insertProduct(ProductDto productDto) {

		Product product = modelMapper.map(productDto, Product.class);

		Product newProduct = productRepository.save(product);

		return modelMapper.map(newProduct, ProductDto.class);

	}

	@Override
	public ProductDto updateProduct(int productId, ProductDto productDto) {

		Product product = modelMapper.map(productDto, Product.class);

		productRepository.save(product);

		return productDto;

	}

	@Override
	public void deleteProduct(int productId) {

		productRepository.deleteById(productId);

	}

	@Override
	public List<ProductDto> getByProductName(String productName) {

		List<Product> products = productRepository.checking(productName);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Product product : products) {
			productDtos.add(modelMapper.map(product, ProductDto.class));
		}

		return productDtos;
	}

	@Override
	public List<ProductDto> findByProductNameAndExpDate(String productName, String expDate) {
		List<Product> products = productRepository.checking101(productName, expDate);
		List<ProductDto> productDtos = new ArrayList<ProductDto>();

		for (Product product : products) {
			productDtos.add(modelMapper.map(product, ProductDto.class));
		}

		return productDtos;
	}

}
