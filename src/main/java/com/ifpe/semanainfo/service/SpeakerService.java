package com.ifpe.semanainfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.email.EmailIsPresentException;
import com.ifpe.semanainfo.model.Speaker;
import com.ifpe.semanainfo.repository.Speaks;



@Service
public class SpeakerService {

	@Autowired
	private Speaks speaks;
	
	public void register(Speaker speaker) throws EmailIsPresentException {
		
	Optional<Speaker> speakerOptional = speaks.findByEmail(speaker.getEmail());
	
	if(speakerOptional.isPresent() && speaker.getId().equals(null)) {
		throw new EmailIsPresentException("Email já cadastrado");
	}
		
		speaks.save(speaker);
	}
}
