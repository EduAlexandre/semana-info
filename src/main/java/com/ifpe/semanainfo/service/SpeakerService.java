package com.ifpe.semanainfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.email.EmailIsPresentException;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.util.PasswordGenerate;



@Service
public class SpeakerService {
	
	public void save(UserModel speaker) {
			
		//variaveis para geração de senha
		String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	    String NUMERIC = "0123456789";
		Integer len = 10;

		String newSenha = PasswordGenerate.generatePassword(len, ALPHA_CAPS + ALPHA + NUMERIC);
		
//		newSenha = Functions.getSHA256(newSenha);
		
		speaker.setPassword(newSenha);
	}
}

