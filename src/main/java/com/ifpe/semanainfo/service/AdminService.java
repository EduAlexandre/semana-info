package com.ifpe.semanainfo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.email.MailerManager;
import com.ifpe.semanainfo.email.MailerSpeaker;
import com.ifpe.semanainfo.email.MailerUser;
import com.ifpe.semanainfo.helper.GeneratePassword;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.Users;


@Service
public class AdminService {

	
	@Autowired
	private Users repositoryUser;
	
	@Autowired
	private MailerManager mailManager;
	
	@Autowired
	private MailerSpeaker mailSpeaker;
	
	@Autowired
	private MailerUser mailUser;
	
	
	
	//GESTOR
	public void saveManager(UserModel manager) {

		String newSenha = GeneratePassword.generatePass();
		
		String newSenhaCrip = GeneratePassword.cripto(newSenha);
		manager.setPassword(newSenhaCrip);
		manager.setActive(false);
		manager.setCodGrup(2);
		manager.setCpf("Não informado");
		
		repositoryUser.save(manager);
		
		manager.setPassword(newSenha);
		mailManager.enviar(manager);
	}
	
	//USUARIO
	public void saveUser(UserModel user) {
		
		user.setActive(false);
		user.setCodGrup(4);
		
		String senha = user.getPassword();
		
		String newSenhaCrip = GeneratePassword.cripto(senha);
		user.setPassword(newSenhaCrip);
		
		repositoryUser.save(user);
		
		user.setPassword(senha);
		mailUser.enviar(user);
	}
	
	//PALESTRANTE
	public void saveSpeaker(UserModel speaker) {

		String newSenha = GeneratePassword.generatePass();
		System.out.println(newSenha);
		String newSenhaCrip = GeneratePassword.cripto(newSenha);
		speaker.setPassword(newSenhaCrip);
		speaker.setActive(false);
		speaker.setCodGrup(3);
		speaker.setCpf("Não informado");
		
		repositoryUser.save(speaker);
		
		speaker.setPassword(newSenha);
		mailSpeaker.enviar(speaker);
	}
	
	public List<UserModel> PickASpeakes(Long id) {
		
		return repositoryUser.pickASpeaker(id);
	}
	
	//TODOS
	
	public void updateStatus(UserModel all) {
		all.setActive(true);
		repositoryUser.saveAndFlush(all);
	}
	
	public UserModel searchAndPickAUser(Long id) {
		return repositoryUser.findById(id).get();
	}
	
	public void deleteOneUser(Long id) {
		repositoryUser.deleteById(id);
	}

	public UserModel pickUpSomeSpecificGroup(int codGroup) {
		return repositoryUser.takeTheCode(codGroup);
	}
	
	public UserModel verificaCPF(String cpf) {
		return repositoryUser.findByCpf(cpf);
	}
	
	public UserModel verificaEmail(String email) { 
		return repositoryUser.findByEmail(email);
	}
	
}
