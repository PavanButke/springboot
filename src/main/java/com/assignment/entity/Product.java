package com.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity

public class Product {
	
	@Id
	private int productId;
	private String productName;
	private String expDate;

	public Product() {
		super();
	}

	public Product(int productId, String productName, String expDate) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.expDate = expDate;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", expDate=" + expDate + "]";
	}

}
