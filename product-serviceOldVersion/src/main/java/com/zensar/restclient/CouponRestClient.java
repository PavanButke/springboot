package com.zensar.restclient;

import javax.ws.rs.ApplicationPath;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zensar.entity.Coupon;

@FeignClient("COUPON-SERVICE")
public interface CouponRestClient {
	
	@GetMapping("/coupons/{couponCode}")
	Coupon getCoupon(@PathVariable String couponCode);
	
	
	
}
