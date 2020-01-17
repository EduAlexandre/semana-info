package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.Admin;



public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query(value =  "select * from admin where email_admin = ?1 AND senha_admin = ?2", nativeQuery = true)
	Admin sarchingAdmin(String email, String senha);

}
