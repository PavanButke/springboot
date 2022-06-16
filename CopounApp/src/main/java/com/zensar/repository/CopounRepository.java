package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zensar.entity.Copoun;

public interface CopounRepository extends JpaRepository<Copoun, Integer> {
	
	@Query(" from Copoun c where c.copounCode=?1")
	List<Copoun> check(String copounCode);
	
	@Query("from Copoun c where c.copounCode=?1 and c.expDate=?2 ")
	List<Copoun> check2(String copounCode, String expDate);

}
