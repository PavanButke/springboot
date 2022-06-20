package com.assignment.dto;

public class ProductDto {

	private int productId;
	private String productName;
	private String expDate;

	public ProductDto() {
		super();
	}

	public ProductDto(int productId, String productName, String expDate) {
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
		return "ProductDto [productId=" + productId + ", productName=" + productName + ", expDate=" + expDate + "]";
	}

}
