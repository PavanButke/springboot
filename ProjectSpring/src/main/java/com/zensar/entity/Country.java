package com.zensar.entity;

public class Country {

	private int countryRanking;
	private String borders;
	private int length;
	public Country() {
		super();
	}
	public Country(int countryRanking, String borders, int length) {
		super();
		this.countryRanking = countryRanking;
		this.borders = borders;
		this.length = length;
	}
	public int getCountryRanking() {
		return countryRanking;
	}
	public void setCountryRanking(int countryRanking) {
		this.countryRanking = countryRanking;
	}
	public String getBorders() {
		return borders;
	}
	public void setBorders(String borders) {
		this.borders = borders;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	@Override
	public String toString() {
		return "India [countryRanking=" + countryRanking + ", borders=" + borders + ", length=" + length + "]";
	}
	public int getCoutryId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
