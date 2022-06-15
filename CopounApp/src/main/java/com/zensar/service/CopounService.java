package com.zensar.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.dto.CopounDto;
import com.zensar.entity.Copoun;

public interface CopounService {
	
	public Copoun getCopoun(int copounIdDto);
	public List<Copoun> getAllCopouns();
	public CopounDto insertCopoun(CopounDto copoun);
	public Copoun updateCopoun(int copounId, CopounDto copounDto);
	public void deleteCopoun(int copounIdDto);
	

}
