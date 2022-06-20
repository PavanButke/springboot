package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("from Product p where p.productName=?1 and p.expDate=?2")
	List<Product> checking101(String productName, String expDate);
	@Query("from Product p where p.productName LIKE CONCAT('%',:productName,'%')")
//	@Query("from Product p where p.productName=?1")
	List<Product> checking(String productName);




}
