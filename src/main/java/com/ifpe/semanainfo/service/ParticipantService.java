package com.ifpe.semanainfo.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifpe.semanainfo.model.Participant;
import com.ifpe.semanainfo.repository.ParticipantDAO;


@Service
public class ParticipantService {
	
	@Autowired
	private ParticipantDAO repository;
	
	public void save(Participant participant) {
		
		//set a hash for participant
		String hashCode = UUID.randomUUID().toString();
		participant.setHashCode(hashCode);
		
		participant.setPermision(1);
		 
		repository.save(participant);
		}
	
		public List<Participant> listAll(){
		return repository.findAll();
		}
	
		public Participant get(Integer idParticipant) {
		return repository.findById(idParticipant).get();
		}
	
		public Participant serching(String email , String senha) {
		return repository.serchingParticipant(email, senha);
		}
	
		public Participant verificaEmail(String email) {
		return repository.serchingEmail(email);
		}
	
	
}
