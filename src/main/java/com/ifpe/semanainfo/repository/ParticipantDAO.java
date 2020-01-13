package com.ifpe.semanainfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ifpe.semanainfo.model.Participant;

public interface ParticipantDAO extends JpaRepository<Participant, Integer> {

	@Query(value =  "select * from participant where email_participant = ?1 AND senha_participant = ?2", nativeQuery = true)
	Participant serchingParticipant(String email, String senha);

	@Query(value =  "select * from participant where email_participant = ?1 ", nativeQuery = true)
	Participant serchingEmail(String email);
}
 