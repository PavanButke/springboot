package com.zensar.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.zensar.entity.Coupon;
import com.zensar.repository.CouponRepository;

@Service
public class CouponServiceImpl implements CouponService {
	
	@Autowired
	private CouponRepository couponRepository;

	@Override
	public Coupon createCoupon(Coupon coupon) {
		return couponRepository.save(coupon);
	}
	
	
	public Coupon getCoupon(String couponCode) {
		return couponRepository.findByCouponCode(couponCode);
	}


	@Override
	public List<Coupon> getAllCoupons() {
		return couponRepository.findAll();
	}

}
