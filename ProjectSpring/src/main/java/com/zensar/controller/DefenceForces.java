package com.zensar.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Country;
import com.zensar.service.DefenceForceService;

@RestController
@RequestMapping("countries-api")
public class DefenceForces {
	
	@Autowired
	private DefenceForceService defenceForceService;

	
	
	
//	@RequestMapping("countries/{countryRanking}")
	@GetMapping(value="countries/{countryRanking}", produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public Country getCountry(@PathVariable("countryRanking") int countryRanking) {
				return defenceForceService.getCountry(countryRanking);
	}
	

//	@RequestMapping(value= {"/countries", "/listofcountries"}, method=RequestMethod.GET)
	@GetMapping(value= {"/countries", "/listofcountries"}, produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})	
	public List<Country> getAllCountries(){
		return defenceForceService.getAllCountries();
		
	}
	
//	@RequestMapping(value= {"/countries"}, method=RequestMethod.POST)
	@PostMapping(value= {"/countries"}, produces = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE})
	public void insertCountry(@RequestBody Country country) {
		defenceForceService.insertCountry(country);
	}	
		
//	@RequestMapping(value="/countries/{countryRanking}", method=RequestMethod.PUT)
	@PutMapping(value="/countries/{countryRanking}" ,consumes  = { MediaType.APPLICATION_JSON_VALUE , MediaType.APPLICATION_XML_VALUE} )
	public void updateCountry(@PathVariable("countryRanking") int countryRanking , @RequestBody Country country) {
		
		defenceForceService.updateCountry(countryRanking, country);
	}
	
//	@RequestMapping(value="/countries/{countryRanking}", method=RequestMethod.DELETE)
	@DeleteMapping(value="/countries/{countryRanking}")
	public void deleteCountry(@PathVariable("countryRanking") int countryRanking) {
		
		defenceForceService.deleteCountry(countryRanking);
	}
	
	
	
	
	
}
