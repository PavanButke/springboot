package com.zensar.services;

import java.util.List;

import com.zensar.entity.Coupon;

public interface CouponService {

	public Coupon createCoupon(Coupon coupon);

	public Coupon getCoupon(String couponCode);
	
	public List<Coupon> getAllCoupons();

}
