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

import com.zensar.dto.CopounDto;
import com.zensar.entity.Copoun;
import com.zensar.service.CopounService;

@RestController
@RequestMapping(value="/copoun-api")
public class CopounController {
	
	@Autowired
	private CopounService copounService;
	
	@GetMapping(value = "/copouns/{copounIdDto}",  produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
	public Copoun getCopoun(@PathVariable("copounIdDto") int copounIdDto) {
		return copounService.getCopoun(copounIdDto);
	}

	@GetMapping(value = { "/copouns", "/listOfCopouns"} ,  produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
	public List<Copoun> getAllCopouns() {
		return copounService.getAllCopouns();
	}

	@PostMapping(value = "/copouns", consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}  )
	public void  insertCopoun(@RequestBody CopounDto copounDto) {
			
		copounService.insertCopoun(copounDto);
			
	}

	@PutMapping(value = "/copouns/{copounIdDto}" , consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE} )
	public void updateCopoun(@PathVariable("copounIdDto") int copounIdDto, @RequestBody CopounDto copounDto) {
		
		copounService.updateCopoun(copounIdDto, copounDto);
	}

	@DeleteMapping(value = "/copouns/{copounIdDto}")
	public void deleteCopoun(@PathVariable("copounIdDto") int copounIdDto) {
		copounService.deleteCopoun(copounIdDto);
	}

}
