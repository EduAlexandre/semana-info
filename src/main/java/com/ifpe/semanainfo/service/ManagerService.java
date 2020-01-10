package com.ifpe.semanainfo.service;


import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.repository.ManagerRepository;





@Service
public class ManagerService {

	@Autowired
	private ManagerRepository repository;
	
	
	public void save(Manager manager) {
		
		//set a hash for manager
		String hashCode = UUID.randomUUID().toString();
		manager.setHashCode(hashCode);
		
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
	
	public void delete(Integer idManager) {
		repository.deleteById(idManager);
	}
	
}
