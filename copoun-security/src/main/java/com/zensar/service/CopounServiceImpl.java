package com.zensar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.CopounDto;
import com.zensar.entity.Copoun;
import com.zensar.repository.CopounRepository;



@Service
public class CopounServiceImpl implements CopounService {
	
	@Autowired
	private CopounRepository copounRepository;

	@Override
	public Copoun getCopoun(int copounIdDto) {
		// TODO Auto-generated method stub
		
		return copounRepository.findById(copounIdDto).get();
	}

	@Override
	public List<Copoun> getAllCopouns() {
		// TODO Auto-generated method stub
		return copounRepository.findAll();
	}

	@Override
	public void insertCopoun(CopounDto copounDto) {
		// TODO Auto-generated method stub
		
		Copoun copoun = new Copoun();
		copoun.setCopounId(copounDto.getCopounId());
		copoun.setCopounCode(copounDto.getCopounCode());
		copoun.setExpDate(copounDto.getExpDate());
		
		
		copounRepository.save(copoun);
		
	}
/*changesbypavan*/
	@Override
	public void updateCopoun(int copounIdDto, CopounDto copounDto) {
		// TODO Auto-generated method stub
		Copoun copoun = new Copoun();
		copoun.setCopounId(copounDto.getCopounId());
		copoun.setCopounCode(copounDto.getCopounCode());
		copoun.setExpDate(copounDto.getExpDate());
		
		
		copounRepository.save(copoun);
	}

	@Override
	public void deleteCopoun(int copounIdDto) {
		// TODO Auto-generated method stub
		copounRepository.deleteById(copounIdDto);

	}

	
	
}
