package com.zensar.entity;

public class Copoun {
	
	private int copounId;
	private String coupounName;
	private int couponPrice;
	public Copoun() {
		super();
	}
	public Copoun(int copounId, String coupounName, int couponPrice) {
		super();
		this.copounId = copounId;
		this.coupounName = coupounName;
		this.couponPrice = couponPrice;
	}
	
	
	public int getCopounId() {
		return copounId;
	}
	public void setCopounId(int copounId) {
		this.copounId = copounId;
	}
	public String getCoupounName() {
		return coupounName;
	}
	public void setCoupounName(String coupounName) {
		this.coupounName = coupounName;
	}
	public int getCouponPrice() {
		return couponPrice;
	}
	public void setCouponPrice(int couponPrice) {
		this.couponPrice = couponPrice;
	}
	@Override
	public String toString() {
		return "Copoun [copounId=" + copounId + ", coupounName=" + coupounName + ", couponPrice=" + couponPrice + "]";
	}
	
	

}
