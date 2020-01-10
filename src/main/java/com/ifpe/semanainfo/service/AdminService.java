package com.ifpe.semanainfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Admin;
import com.ifpe.semanainfo.repository.AdminRepository;


@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	
	public void save(Admin admin) {
		
		admin.setPermission(4);
		
		repository.save(admin);
	}
	
	public List<Admin> listAll(){
		return repository.findAll();
	}
	
	public Admin get(Integer idAdmin) {
		return repository.findById(idAdmin).get();
	}
	
	public Admin sarchingAdmin(String email , String senha) {
		return repository.sarchingAdmin(email, senha);
	}
	
	public void delete(Integer idAdmin) {
		repository.deleteById(idAdmin);
	}
}
