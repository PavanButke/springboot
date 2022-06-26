package com.zensar.service;


import java.util.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Country;
@Service
public class DefenceForceServiceImpl  implements DefenceForceService{

private List<Country> countries = new ArrayList<Country>();
	
	public DefenceForceServiceImpl() {
		countries.add(new Country(1,"NewZeland",89));
		countries.add(new Country(2,"India",99));
		countries.add(new Country(3,"Finland",19));
	}
	@Override
	public Country getCountry(int countryRanking) {
		for(Country country : countries) {
			if(country.getCountryRanking()== countryRanking) {
				return country;
			}
		}

		return null;
	}

	@Override
	public List<Country> getAllCountries() {
		return countries;
		
	}

	@Override
	public void insertCountry(Country country) {
		countries.add(country);
		
	}

	@Override
	public void updateCountry(int countryRanking, Country country) {
		// TODO Auto-generated method stub
		Country country2 = getCountry(countryRanking);
		country2.setCountryRanking(country.getCountryRanking());
		country2.setBorders(country.getBorders());
		country2.setLength(country.getLength());
		
		countries.add(country2);
		
	}

	@Override
	public void deleteCountry(int countryRanking) {
		// TODO Auto-generated method stub
		for(int i=0 ; i<countries.size();i++) {
			
			Country country = countries.get(i);
			if(country.getCountryRanking()==countryRanking) {
				countries.remove(country);
			}
		}
	}

}
