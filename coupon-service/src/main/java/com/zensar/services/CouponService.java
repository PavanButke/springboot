package com.zensar.services;

import com.zensar.entity.Coupon;

public interface CouponService {

	public Coupon createCoupon(Coupon coupon);

	public Coupon getCoupon(String couponCode);

}
