package com.zensar.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zensar.entity.Copoun;


@Service
public class CopounServiceImpl implements CopounService {
	
	private List<Copoun> copouns = new ArrayList<Copoun>();
	
	public CopounServiceImpl() {
		copouns.add(new Copoun(101, "Zomato60", 300));
		copouns.add(new Copoun(102, "AJIO124", 280));
		copouns.add(new Copoun(103, "MyntraFirst", 260));
	}


	@Override
	public Copoun getCopoun(int copounId) {
		// TODO Auto-generated method stub
		
		System.out.println("Hi"+copounId);
		for (Copoun copoun : copouns) {
			if (copoun.getCopounId() == copounId) {
				return copoun;
			}

		}
		return null;
	}

	@Override
	public List<Copoun> getAllCopouns() {
		// TODO Auto-generated method stub
		return copouns;
	}

	@Override
	public void insertCopoun(Copoun copoun) {
		// TODO Auto-generated method stub
		copouns.add(copoun);
		
	}

	@Override
	public void updateCopoun(int copounId, Copoun copoun) {
		// TODO Auto-generated method stub
		Copoun copounNew = getCopoun(copounId);
		copounNew.setCopounId(copoun.getCopounId());
		copounNew.setCopounName(copoun.getCopounName());
		copounNew.setCopounPrice(copoun.getCopounPrice());

		copouns.add(copounNew);
	}

	@Override
	public void deleteCopoun(int copounId) {
		// TODO Auto-generated method stub
		for (int i = 0; i < copouns.size(); i++) {
			Copoun copoun = copouns.get(i);
			if (copoun.getCopounId() == copounId) {
				copouns.remove(copoun);
			}

		}

	}

	
	
}
