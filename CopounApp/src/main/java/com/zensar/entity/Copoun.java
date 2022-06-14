package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Copoun {
	@Id
	private int copounId;
	private String copounName;
	private int copounPrice;
	public Copoun() {
		super();
	}
	
	public Copoun(int copounId, String copounName, int copounPrice) {
		super();
		this.copounId = copounId;
		this.copounName = copounName;
		this.copounPrice = copounPrice;
	}
	
	
	public int getCopounId() {
		return copounId;
	}
	public void setCopounId(int copounId) {
		this.copounId = copounId;
	}
	public String getCopounName() {
		return copounName;
	}
	public void setCopounName(String copounName) {
		this.copounName = copounName;
	}
	public int getCopounPrice() {
		return copounPrice;
	}
	public void setCopounPrice(int copounPrice) {
		this.copounPrice = copounPrice;
	}
	@Override
	public String toString() {
		return "Copoun [copounId=" + copounId + ", copounName=" + copounName + ", copounPrice=" + copounPrice + "]";
	}
	
	

}
