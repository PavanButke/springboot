package com.zensar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;

@Entity
//@NamedNativeQueries(value = {
//		@NamedNativeQuery(name = "Copoun.check", query = "SELECT * FROM Copoun WHERE copoun_code=?1", resultClass = Copoun.class),
//		@NamedNativeQuery(name = "Copoun.check2", query = "SELECT * FROM Copoun WHERE copoun_code =?1 and exp_date=?2", resultClass = Copoun.class) })
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
