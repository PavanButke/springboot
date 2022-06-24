package com.zensar.controllers;

import java.util.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.dto.CopounDto;
import com.zensar.entity.Copoun;
import com.zensar.service.CopounService;


@RestController
@RequestMapping(value = "/copoun-api", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
				MediaType.APPLICATION_XML_VALUE })
public class CopounController {

	@Autowired
	private CopounService copounService;

	@GetMapping(value = "/copouns/{copounId}")
	public ResponseEntity<CopounDto> getCopoun(@PathVariable("copounId") int copounId) {
//		return copounService.getCopoun(copounId);

		return new ResponseEntity<CopounDto>(copounService.getCopoun(copounId), HttpStatus.OK);
	}

	@GetMapping(value = { "/copouns", "/listOfCopouns" })
	public ResponseEntity<List<CopounDto>> getAllCopouns(@RequestParam(value = "pageNumber", required = false ,defaultValue = "0")int pageNumber , @RequestParam(value = "pageSize" , required = false , defaultValue="3") int pageSize , @RequestParam(value = "order" , required = false , defaultValue = "true" ) boolean order, @RequestParam(value = "sort" , required = false , defaultValue = "copounCode" ) String... properties) {
		return new ResponseEntity<List<CopounDto>>(copounService.getAllCopouns(pageNumber,pageSize, order ,properties), HttpStatus.OK);
	}
	


	@PostMapping(value = "/copouns")
	public ResponseEntity<CopounDto> insertCopoun(@RequestBody CopounDto copounDto) {

		return new ResponseEntity<CopounDto>(copounService.insertCopoun(copounDto), HttpStatus.CREATED);

	}

	@PutMapping(value = "/copouns/{copounId}")
	public ResponseEntity<CopounDto> updateCopoun(@PathVariable("copounId") int copounId,
			@RequestBody CopounDto copounDto) {

//		return copounService.updateCopoun(copounId, copounDto);
		return new ResponseEntity<CopounDto>(copounService.updateCopoun(copounId, copounDto), HttpStatus.CREATED);
	}

	@DeleteMapping(value = "/copouns/{copounId}")
	public ResponseEntity<String> deleteCopoun(@PathVariable("copounId") int copounId) {
		copounService.deleteCopoun(copounId);
		return new ResponseEntity<String>("You Losted the copoun!", HttpStatus.OK);
	}

	@GetMapping("/copouns/offer/{copounCode}")
	public ResponseEntity< List<CopounDto>> getByCopounCode(@PathVariable("copounCode") String copounCode) {
		
		return new ResponseEntity<List<CopounDto>>(copounService.getByCopounCode(copounCode), HttpStatus.OK);
				
	}

	@GetMapping("/copouns/{copounCode}/{expDate}")
	public ResponseEntity< List<CopounDto>> findByCopounCodeAndExpDate(@PathVariable("copounCode") String copounCode,
			@PathVariable("expDate") String expDate) {
		 
		return new ResponseEntity<List<CopounDto>>(copounService.findByCopounCodeAndExpDate(copounCode, expDate), HttpStatus.OK);
	}
}
