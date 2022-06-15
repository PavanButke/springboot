package com.zensar.dto;

public class CopounDto {
	
	private int copounId;
	private String copounCode;
	private String expDate;
	public CopounDto() {
		super();
	}
	public CopounDto(int copounId, String copounCode, String expDate) {
		super();
		this.copounId = copounId;
		this.copounCode = copounCode;
		this.expDate = expDate;
	}	/*changesbypavan*/
	
	
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
		return "CopounDto [copounId=" + copounId + ", copounCode=" + copounCode + ", expDate=" + expDate + "]";
	}
	

		
}
