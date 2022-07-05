package com.zensar.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.entity.JwtRequest;
import com.zensar.entity.JwtResponse;
import com.zensar.helper.JwtHelper;
import com.zensar.service.UserCredService;

@RestController
public class JwtController {
	
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserCredService userCredService;
	@Autowired
	private JwtHelper jwtHelper;

	@PostMapping(value = "/token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
		System.out.println(jwtRequest);

		try {

			this.authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(), jwtRequest.getPassword()));

		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");

		} catch (BadCredentialsException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentials");
		}

		UserDetails userDetails = this.userCredService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtHelper.generateToken(userDetails);

		System.out.println("This is JWT" + token);
		return ResponseEntity.ok(new JwtResponse(token));

	}
	
	
}
