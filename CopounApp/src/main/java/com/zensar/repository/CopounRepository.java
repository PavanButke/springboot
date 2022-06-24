package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zensar.entity.Copoun;

public interface CopounRepository extends JpaRepository<Copoun, Integer> {
	
	@Query(value="select * from Copoun c where c.copoun_code=:code", nativeQuery=true)
	List<Copoun> check(@Param("code")String copounCode);
	
	@Query("from Copoun c where c.copounCode=:code and c.expDate=:expDate ")
	List<Copoun> check2(@Param("code") String copounCode, @Param("expDate")String expDate);

}
