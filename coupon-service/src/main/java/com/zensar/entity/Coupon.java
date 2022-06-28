package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int couponId;
	private String couponCode;
	private Double discount;
	private String expDate;

	/*
	 * public Coupon() { super(); }
	 * 
	 * public Coupon(int couponId, String couponCode, Double discount, String
	 * expDate) { super(); this.couponId = couponId; this.couponCode = couponCode;
	 * this.discount = discount; this.expDate = expDate; }
	 * 
	 * public int getCouponId() { return couponId; }
	 * 
	 * public void setCouponId(int couponId) { this.couponId = couponId; }
	 * 
	 * public String getCouponCode() { return couponCode; }
	 * 
	 * public void setCouponCode(String couponCode) { this.couponCode = couponCode;
	 * }
	 * 
	 * public Double getDiscount() { return discount; }
	 * 
	 * public void setDiscount(Double discount) { this.discount = discount; }
	 * 
	 * public String getExpDate() { return expDate; }
	 * 
	 * public void setExpDate(String expDate) { this.expDate = expDate; }
	 * 
	 * @Override public String toString() { return "Coupon [couponId=" + couponId +
	 * ", couponCode=" + couponCode + ", discount=" + discount + ", expDate=" +
	 * expDate + "]"; }
	 */
}
