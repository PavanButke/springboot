package com.zensar.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.entity.Country;

public interface DefenceForceService {
	
	 	public Country getCountry( int countryRanking);
		public List<Country> getAllCountries();
		public void insertCountry( Country country);
		public void updateCountry(int countryRanking ,  Country country);
		public void deleteCountry(int countryRanking);

}
