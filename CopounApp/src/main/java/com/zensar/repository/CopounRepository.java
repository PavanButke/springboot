package com.zensar.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zensar.entity.Copoun;

public interface CopounRepository extends JpaRepository<Copoun, Integer> {

	List<Copoun> check(String copounCode);

	List<Copoun> check2(String copounCode, String expDate);

}
