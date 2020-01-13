package com.ifpe.semanainfo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Participant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idParticipant;
	
	private String nomeParticipant;
	
	private String cpf;
	
	private String email;
	
	private String senha;
	
	private String hashCode;
	
	private int permision;
	
	@ManyToMany
	@JoinTable(name = "user_groups", joinColumns = @JoinColumn(name = "id_user"), inverseJoinColumns = @JoinColumn(name = "id_group"))
	private List<Groups> groups;

	public Integer getIdParticipant() {
		return idParticipant;
	}

	public void setIdParticipant(Integer idParticipant) {
		this.idParticipant = idParticipant;
	}

	public String getNomeParticipant() {
		return nomeParticipant;
	}

	public void setNomeParticipant(String nomeParticipant) {
		this.nomeParticipant = nomeParticipant;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
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

	public String getHashCode() {
		return hashCode;
	}

	public void setHashCode(String hashCode) {
		this.hashCode = hashCode;
	}

	public int getPermision() {
		return permision;
	}

	public void setPermision(int permision) {
		this.permision = permision;
	}

	public List<Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}
	

}
