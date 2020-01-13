package com.ifpe.semanainfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.email.EmailIsPresentException;
import com.ifpe.semanainfo.model.Speaker;
import com.ifpe.semanainfo.repository.Speaks;
import com.ifpe.semanainfo.util.PasswordGenerate;



@Service
public class SpeakerService {

	@Autowired
	private Speaks speaks;
	
	public void save(Speaker speaker) {
			
		//variaveis para geração de senha
		String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	    String NUMERIC = "0123456789";
		Integer len = 10;

		String newSenha = PasswordGenerate.generatePassword(len, ALPHA_CAPS + ALPHA + NUMERIC);
		
//		newSenha = Functions.getSHA256(newSenha);
		
		speaker.setPassword(newSenha);
		
		speaker.setPermision(2);
		
		speaks.save(speaker);
	}
	
	public List<Speaker> listAll(){
		return speaks.findAll();
	}
	
	public void delete(Integer idSpeaker) {
		speaks.deleteById(idSpeaker);
	}
	
	public void register(Speaker speaker) throws EmailIsPresentException {
		
		Optional<Speaker> speakerOptional = speaks.findByEmail(speaker.getEmail());
		
		if(speakerOptional.isPresent() && speaker.getId().equals(null)) {
			throw new EmailIsPresentException("Email já cadastrado");
		}
		
		speaks.save(speaker);
	}
}
