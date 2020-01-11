package com.ifpe.semanainfo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Manager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idManager;
	
	private String nomeManager;
	
	private String email;
	
	private String senha;
	
	private int permission;

	public Integer getIdManager() {
		return idManager;
	}

	public void setIdManager(Integer idManager) {
		this.idManager = idManager;
	}

	public String getNomeManager() {
		return nomeManager;
	}

	public void setNomeManager(String nomeManager) {
		this.nomeManager = nomeManager;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public int getPermission() {
		return permission;
	}

	public void setPermission(int permission) {
		this.permission = permission;
	}
	
	
	
	
	
}
