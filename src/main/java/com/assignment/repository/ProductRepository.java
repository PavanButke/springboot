package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {



	List<Product> getByProductName(String productName);




}
