package com.zensar.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.Copoun;

@RestController
@RequestMapping("/copoun-api")
public class CopounController {

	private List<Copoun> copouns = new ArrayList<Copoun>();

	public CopounController() {
		copouns.add(new Copoun(101, "Zomato60", 300));
		copouns.add(new Copoun(102, "AJIO124", 280));
		copouns.add(new Copoun(103, "MyntraFirst", 260));
	}
	
	
	@RequestMapping(value="/copouns/{copounId}" , method=RequestMethod.GET)
	public Copoun getCopoun(@PathVariable("copounId") int CopounId) {
		
		for(Copoun copoun:copouns) {
			if(copoun.getCopounId()==CopounId) {
				return copoun;
			}
			
		}
		return null;
	}

	
	
	@RequestMapping(value = { "/copouns", "/listOfCopouns" },method=RequestMethod.GET)
	public List<Copoun> getAllStudents() {
		return copouns;
	}
	
	
	@RequestMapping(value = "/copouns",method=RequestMethod.POST)
	public void insertStudent(@RequestBody Copoun copoun) {
		copouns.add(copoun);
	
	}
	
	@RequestMapping(value="/copouns/{copounId}",method=RequestMethod.PUT)
	public void updateStudent(@PathVariable("copounId")int copounId,@RequestBody Copoun copoun) {
		Copoun copounNew = getCopoun(copounId);
		copounNew.setCopounId(copoun.getCopounId());
		copounNew.setCoupounName(copoun.getCoupounName());
		copounNew.setCouponPrice(copoun.getCouponPrice());
		
		copouns.add(copounNew);
	}
		@RequestMapping(value="/copouns/{copounId}",method=RequestMethod.DELETE)
		public void deleteStudent(@PathVariable("copounId")int copounId) {
			for(int i=0;i<copouns.size();i++) {
				Copoun copoun=copouns.get(i);
				if(copoun.getCopounId()==copounId) {
					copouns.remove(copoun);
				}
				
			}
		
	}
	
}
