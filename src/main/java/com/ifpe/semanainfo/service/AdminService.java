package com.ifpe.semanainfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.email.MailerManager;
import com.ifpe.semanainfo.email.MailerUser;
import com.ifpe.semanainfo.helper.GeneratePassword;
import com.ifpe.semanainfo.model.Admin;
import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.AdminRepository;
import com.ifpe.semanainfo.repository.Users;
import com.ifpe.semanainfo.util.PasswordGenerate;


@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;
	
	@Autowired
	private Users repositoryUser;
	
	@Autowired
	private MailerManager mailManager;
	
	@Autowired
	private MailerUser mailUser;
	
	public void save(Admin admin) {
		repository.save(admin);	
	}
	//GESTOR
	public void saveManager(UserModel manager) {
		
		//variaveis para geração de senha
		String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	    String NUMERIC = "0123456789";
		Integer len = 6;

		String newSenha = PasswordGenerate.generatePassword(len, ALPHA_CAPS + ALPHA + NUMERIC);
		
		String newSenhaCrip = GeneratePassword.cripto(newSenha);
		manager.setPassword(newSenhaCrip);
		manager.setActive(false);
		manager.setCodGrup(2);
		manager.setCpf("Não informado");
		
		repositoryUser.save(manager);
		
		manager.setPassword(newSenha);
		mailManager.enviar(manager);
	}
	
	public UserModel searchingManager(Long id) {
		return repositoryUser.searchingManager(id);
	}
	
	//USUARIO
	public void saveUser(UserModel user) {
		
		
		user.setActive(false);
		user.setCodGrup(4);
		
		String newSenhaCrip = GeneratePassword.cripto(user.getPassword());
		user.setPassword(newSenhaCrip);
		
		repositoryUser.save(user);
		
		mailUser.enviar(user);
	}
	
	public UserModel searchGetUser(Long id) {
		return repositoryUser.findById(id).get();
	}
	
	public void updateStatus(UserModel user) {
		user.setActive(true);
		repositoryUser.saveAndFlush(user);
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
