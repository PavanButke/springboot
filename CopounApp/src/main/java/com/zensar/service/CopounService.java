package com.zensar.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.zensar.dto.CopounDto;
import com.zensar.entity.Copoun;

public interface CopounService {
	
	public CopounDto getCopoun(int copounId);
	public List<CopounDto> getAllCopouns();
	public CopounDto insertCopoun(CopounDto copoun);
	public CopounDto updateCopoun(int copounId, CopounDto copounDto);
	public void deleteCopoun(int copounId);
	List<Copoun> getByCopounCode(String copounName);

}
