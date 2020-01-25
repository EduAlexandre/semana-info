package com.ifpe.semanainfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Registrations {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_registration;

	@ManyToOne
	private Activity activity;

	@ManyToOne
	private UserModel user;
	
	private String timeIniActivy;
	
	private Boolean presenca;

	public Integer getId_registration() {
		return id_registration;
	}

	public void setId_registration(Integer id_registration) {
		this.id_registration = id_registration;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public String getTimeIniActivy() {
		return timeIniActivy;
	}

	public void setTimeIniActivy(String timeIniActivy) {
		this.timeIniActivy = timeIniActivy;
	}

	public Boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean presenca) {
		this.presenca = presenca;
	}
	
}
