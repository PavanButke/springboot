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
	public CopounDto insertCopoun(CopounDto copounDto) {
		// TODO Auto-generated method stub
		
		Copoun copoun= mapToEntity(copounDto);
		
		
		
//		Copoun copoun = new Copoun();
//		copoun.setCopounId(copounDto.getCopounId());
//		copoun.setCopounCode(copounDto.getCopounCode());
//		copoun.setExpDate(copounDto.getExpDate());
//		codebypavan130797
		
		Copoun generatedCopoun = copounRepository.save(copoun);
		
		CopounDto dto = new CopounDto();
		dto.setCopounId(generatedCopoun.getCopounId());
		dto.setCopounCode(generatedCopoun.getCopounCode());
		dto.setExpDate(generatedCopoun.getExpDate());
		
		return dto;
		
	}
/*changesbypavan*/
	@Override
	public Copoun updateCopoun(int copounIdDto, CopounDto copounDto) {
		// changesbypavan TODO Auto-generated method stub
//		Copoun copoun = new Copoun();
//		copoun.setCopounId(copounDto.getCopounId());
//		copoun.setCopounCode(copounDto.getCopounCode());
//		copoun.setExpDate(copounDto.getExpDate());
//		
		Copoun copoun= mapToEntity(copounDto);
		
		copounRepository.save(copoun);
		return copoun;
	}

	@Override
	public void deleteCopoun(int copounIdDto) {
		// TODO Auto-generated method stub
		copounRepository.deleteById(copounIdDto);

	}

	public Copoun mapToEntity(CopounDto copounDto ) {

	Copoun copoun = new Copoun();
	copoun.setCopounId(copounDto.getCopounId());
	copoun.setCopounCode(copounDto.getCopounCode());
	copoun.setExpDate(copounDto.getExpDate());
	
	return copoun;
	
}

}
