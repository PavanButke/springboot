package com.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.assignment.dto.ProductDto;
import com.assignment.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value="Select * from Product p where p.product_name=:name and p.exp_date=:exp" , nativeQuery=true)
	List<ProductDto> checking101(@Param("name") String productName,@Param("exp") String expDate);
	@Query(value=" from Product p where p.productName=:name" , nativeQuery = false)
//	@Query("from Product p where p.productName LIKE CONCAT('%',:productName,'%')")
    List<ProductDto> checking(@Param("name")String productName);
}
