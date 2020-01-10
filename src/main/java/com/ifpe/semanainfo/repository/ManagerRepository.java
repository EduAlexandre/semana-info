package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.Manager;





public interface ManagerRepository extends JpaRepository<Manager, Integer> {
	
	
	@Query(value =  "select * from manager where email_manager = ?1 AND senha_manager = ?2", nativeQuery = true)
	Manager sarchingManager(String email, String senha);

	@Query(value =  "select * from manager where email_maneger = ?1 ", nativeQuery = true)
	Manager sarchingEmail(String email);
}
