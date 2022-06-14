package com.zensar.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.entity.Copoun;

public interface CopounService {
	
	public Copoun getCopoun(int copounId);
	public List<Copoun> getAllCopouns();
	public void insertCopoun(Copoun copoun);
	public void updateCopoun(int copounId, Copoun copoun);
	public void deleteCopoun(int copounId);
	

}
