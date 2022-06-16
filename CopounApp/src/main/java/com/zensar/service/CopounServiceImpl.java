package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zensar.dto.CopounDto;
import com.zensar.entity.Copoun;
import com.zensar.repository.CopounRepository;




@Service
public class CopounServiceImpl implements CopounService {
	
	@Autowired
	private CopounRepository copounRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CopounDto getCopoun(int copounId) {
		// TODO Auto-generated method stub
		Copoun copoun = copounRepository.findById(copounId).get();
//		CopounDto dto = mapToDto(copoun);
//		return dto;
//	codebypavan
		
		return modelMapper.map(copoun, CopounDto.class);
		
	}

	@Override
	public List<CopounDto> getAllCopouns() {
		// TODO Auto-generated method stub
		
		List<Copoun> copounList = copounRepository.findAll();
		
		List<CopounDto> copounListDto = new ArrayList<CopounDto>();
		for(Copoun copoun : copounList) {
				copounListDto.add(modelMapper.map(copoun, CopounDto.class));	
		}
		
		return copounListDto;
		
		
		
	}

	@Override
	public CopounDto insertCopoun(CopounDto copounDto) {
		// TODO Auto-generated method stub
		
//		Copoun copoun= mapToEntity(copounDto);
		
		Copoun copoun = modelMapper.map(copounDto, Copoun.class);
		
//		Copoun copoun = new Copoun();
//		copoun.setCopounId(copounDto.getCopounId());
//		copoun.setCopounCode(copounDto.getCopounCode());
//		copoun.setExpDate(copounDto.getExpDate());
//		codebypavan130797
		
		Copoun generatedCopoun = copounRepository.save(copoun);
		
//		CopounDto dto = new CopounDto();
//		dto.setCopounId(generatedCopoun.getCopounId());
//		dto.setCopounCode(generatedCopoun.getCopounCode());
//		dto.setExpDate(generatedCopoun.getExpDate());
//		
//		 CopounDto dto= mapToDto(generatedCopoun);
		
		 return  modelMapper.map(generatedCopoun, CopounDto.class);
		
	}
/*changesbypavan*/
	@Override
	public CopounDto updateCopoun(int copounId, CopounDto copounDto) {
		// changesbypavan TODO Auto-generated method stub
//		Copoun copoun = new Copoun();
//		copoun.setCopounId(copounDto.getCopounId());
//		copoun.setCopounCode(copounDto.getCopounCode());
//		copoun.setExpDate(copounDto.getExpDate());
//		
		Copoun copoun=  modelMapper.map(copounDto, Copoun.class);
		
		copounRepository.save(copoun);
		return copounDto;
	}

	@Override
	public void deleteCopoun(int copounId) {
		// TODO Auto-generated method stub
		copounRepository.deleteById(copounId);

	}

	@Override
	public List<Copoun> getByCopounCode(String copounCode) {
		// TODO Auto-generated method stub
		return copounRepository.findByCopounCode(copounCode);
	}

	@Override
	public List<Copoun> findByCopounCodeAndExpDate(String copounCode, String expDate) {
		// TODO Auto-generated method stub
		return copounRepository.findByCopounCodeAndExpDate(copounCode ,expDate);
	
	}

	
//	public CopounDto mapToDto(Copoun copoun ) {
//
//		CopounDto dto = new CopounDto();
//		dto.setCopounId(copoun.getCopounId());
//		dto.setCopounCode(copoun.getCopounCode());
//		dto.setExpDate(copoun.getExpDate());
//		
//		return dto;
//	}
//	
//	public Copoun mapToEntity(CopounDto copounDto ) {
//
//	Copoun copoun = new Copoun();
//	copoun.setCopounId(copounDto.getCopounId());
//	copoun.setCopounCode(copounDto.getCopounCode());
//	copoun.setExpDate(copounDto.getExpDate());
//	
//	return copoun;
//	
//}

}
