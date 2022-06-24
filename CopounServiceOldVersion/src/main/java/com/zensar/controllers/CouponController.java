package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Coupon;
import com.zensar.services.CouponService;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	private CouponService couponService;

	@PostMapping("/")
	public Coupon createCoupon(@RequestBody Coupon coupon) {
		return couponService.createCoupon(coupon);
	}

	// http://localhost:8080/coupons/MAX50 -> GET
	@GetMapping("/{couponCode}")
	public Coupon getCoupon(@PathVariable("couponCode") String couponCode) {
		System.out.println("Hello");
		return couponService.getCoupon(couponCode);
	}
	

}
