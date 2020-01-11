package com.ifpe.semanainfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.semanainfo.model.Speaker;



public interface Speaks extends JpaRepository<Speaker, Integer> {
	
	public Optional<Speaker> findByEmail(String email);

	

}
