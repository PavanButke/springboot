package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Copoun;

public interface CopounRepository extends JpaRepository<Copoun, Integer> {
	


	List<Copoun> getByCopounCode(String copounCode);

}
