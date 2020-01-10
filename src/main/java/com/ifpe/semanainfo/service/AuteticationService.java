package com.ifpe.semanainfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Manager;



@Service
public class AuteticationService {

	@Autowired
	private ManagerService serviceManager;
		
	
	
	public void autenciaUsuario(Manager manager) {
		Manager usuarioGetHash = serviceManager.verificationHashCode(manager.getHashCode());
		
		if(!usuarioGetHash.isPresent()) {	
			
			usuarioGetHash.setAtivo(1);
			usuarioGetHash.setNomeManager(manager.getNomeManager());
			usuarioGetHash.setSenha(manager.getSenha());
						
			serviceManager.save(usuarioGetHash);
			
		}			
		
		
	}
	
	
}
