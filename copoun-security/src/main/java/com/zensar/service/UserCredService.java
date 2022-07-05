package com.zensar.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import  org.springframework.security.core.userdetails. User;

@Service
public class UserCredService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		if (userName.equals("Admin")) {
			return new User ( "Admin", "Admin", new ArrayList<>()); // userName , Pass 
			}else {
				if (userName.equals("User")) {
					return new User ( "User", "User", new ArrayList<>()); // userName , Pass 
					}
			else {
			throw new UsernameNotFoundException ("User Does Not Exists !!");
			}
	}

	}
}
