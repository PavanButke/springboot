package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Copoun {
	@Id
	private int copounId;
	private String copounCode;
	private String expDate;
	public Copoun() {
		super();
	}
	
	public Copoun(int copounId, String copounCode, String expDate) {
		super();
		this.copounId = copounId;
		this.copounCode = copounCode;
		this.expDate = expDate;
	}

	public int getCopounId() {
		return copounId;
	}

	public void setCopounId(int copounId) {
		this.copounId = copounId;
	}

	public String getCopounCode() {
		return copounCode;
	}

	public void setCopounCode(String copounCode) {
		this.copounCode = copounCode;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	@Override
	public String toString() {
		return "Copoun [copounId=" + copounId + ", copounCode=" + copounCode + ", expDate=" + expDate + "]";
	}
	
	

	

}
