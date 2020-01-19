package com.ifpe.semanainfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.model.Registrations;

public interface RegistrationsRepository extends JpaRepository<Registrations, Integer> {


	@Query(value =  "select * from registrations where user_id = ?1", nativeQuery = true)
	public List<Registrations> pickAllForId(Integer id);

	public List<Registrations> findAllByUserId(Integer id);
	
	@Query(value =  "select * from registrations where time_ini = ?1 AND user_id = ?2", nativeQuery = true)
	public Registrations pickTimeIniUser(String time, Integer id);

}
