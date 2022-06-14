package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.entity.Copoun;
import com.zensar.repository.CopounRepository;


@Service
public class CopounServiceImpl implements CopounService {
	
	@Autowired
	private CopounRepository copounRepository;

	@Override
	public Copoun getCopoun(int copounId) {
		// TODO Auto-generated method stub
		
		return copounRepository.findById(copounId).get();
	}

	@Override
	public List<Copoun> getAllCopouns() {
		// TODO Auto-generated method stub
		return copounRepository.findAll();
	}

	@Override
	public void insertCopoun(Copoun copoun) {
		// TODO Auto-generated method stub
		copounRepository.save(copoun);
		
	}

	@Override
	public void updateCopoun(int copounId, Copoun copoun) {
		// TODO Auto-generated method stub
			copounRepository.save(copoun);
	}

	@Override
	public void deleteCopoun(int copounId) {
		// TODO Auto-generated method stub
		copounRepository.deleteById(copounId);

	}

	
	
}
