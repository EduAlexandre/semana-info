package com.ifpe.semanainfo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.helper.UsersQueries;


public interface Users extends JpaRepository<UserModel, Long>, UsersQueries {

	public Optional<UserModel> findByEmailIgnoreCaseAndActiveTrue(String email);
	
}
