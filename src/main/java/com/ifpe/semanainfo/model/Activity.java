package com.ifpe.semanainfo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class Activity { 
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nameEvent;
	
	private int amountVacancies;
	
	@ManyToMany
	private List<Room> room;
	
	@OneToOne
	private UserModel speaker;

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

	public UserModel getSpeaker() {
		return speaker;
	}

	public void setSpeaker(UserModel speaker) {
		this.speaker = speaker;
	}
	

	
	
	
}
