package com.zensar.controllers;

import java.util.*;
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

import com.zensar.entity.Copoun;
import com.zensar.service.CopounService;

@RestController
@RequestMapping("/copoun-api")
public class CopounController {
	
	@Autowired
	private CopounService copounService;
	
	@GetMapping(value = "/copouns/{copounId}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Copoun getCopoun(@PathVariable("copounId") int copounId) {
		return copounService.getCopoun(copounId);
	}

	@GetMapping(value = { "/copouns", "/listOfCopouns"}, produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public List<Copoun> getAllCopouns() {
		return copounService.getAllCopouns();
	}

	@PostMapping(value = "/copouns" , consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void  insertCopoun(@RequestBody Copoun copoun) {
			
		copounService.insertCopoun(copoun);
			
	}

	@PutMapping(value = "/copouns/{copounId}" , consumes =  {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public void updateCopoun(@PathVariable("copounId") int copounId, @RequestBody Copoun copoun) {
		
		copounService.updateCopoun(copounId, copoun);
	}

	@DeleteMapping(value = "/copouns/{copounId}")
	public void deleteCopoun(@PathVariable("copounId") int copounId) {
		copounService.deleteCopoun(copounId);
	}

}
