package com.ifpe.semanainfo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.helper.UsersQueries;


public interface Users extends JpaRepository<UserModel, Long>, UsersQueries {

	public Optional<UserModel> findByEmailIgnoreCaseAndActiveTrue(String email);

	@Query(value =  "select * from user_model where id = ?1", nativeQuery = true)
	public UserModel searchingManager(Long id);

	@Query(value =  "select * from user_model where cod_grup = ?1 and active = 1", nativeQuery = true)
	public UserModel takeTheCode(int codGroup);

	public UserModel findByCpf(String cpf);

	public UserModel findByEmail(String email);
	
	@Query(value =  "select * from user_model where cod_grup = ?1", nativeQuery = true)
	public List<UserModel> pickASpeaker(Long id);

	public UserModel findById(UserModel speaker);
	
	
}
