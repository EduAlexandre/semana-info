package com.ifpe.semanainfo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.repository.ManagerRepository;
import com.ifpe.semanainfo.util.PasswordGenerate;





@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repository;
	
	
	public void save(Manager manager) {
		
		//variaveis para geração de senha
		String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	    String NUMERIC = "0123456789";
		Integer len = 10;

		String newSenha = PasswordGenerate.generatePassword(len, ALPHA_CAPS + ALPHA + NUMERIC);
		
//		newSenha = Functions.getSHA256(newSenha);
		
		manager.setSenha(newSenha);
		
		manager.setPermission(3);
		
		repository.save(manager);
	}
	
	public List<Manager> listAll(){
		return repository.findAll();
	}
	
	public Manager get(Integer idManager) {
		return repository.findById(idManager).get();
	}
	
	public Manager sarching(String email , String senha) {
		return repository.sarchingManager(email, senha);
	}
	
	public Manager verificationEmail(String email) {
		return repository.sarchingEmail(email);
	}
	
	public Manager verificationHashCode(String hashCode) {
		return repository.sarchingHashCode(hashCode);
	}
	
	public void delete(Integer idManager) {
		repository.deleteById(idManager);
	}

	public Manager searchingHashCode(String hashCode) {
		return repository.sarchingHashCode(hashCode);
	}
	
}
