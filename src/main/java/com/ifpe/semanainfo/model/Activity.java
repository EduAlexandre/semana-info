package com.ifpe.semanainfo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Activity { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nameEvent;
	
	private int amountVacancies;
	
	@Column(length = 255)
	private String description;
	
	private String room;
	
	private String speaker;
	
	private String timeIni;
	
	private String timeFim;
	
	private String duracao;
		
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameEvent() {
		return nameEvent;
	}

	public void setNameEvent(String nameEvent) {
		this.nameEvent = nameEvent;
	}

	public int getAmountVacancies() {
		return amountVacancies;
	}

	public void setAmountVacancies(int amountVacancies) {
		this.amountVacancies = amountVacancies;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getSpeaker() {
		return speaker;
	}

	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	public String getTimeIni() {
		return timeIni;
	}

	public void setTimeIni(String timeIni) {
		this.timeIni = timeIni;
	}

	public String getTimeFim() {
		return timeFim;
	}

	public void setTimeFim(String timeFim) {
		this.timeFim = timeFim;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}


	


}
