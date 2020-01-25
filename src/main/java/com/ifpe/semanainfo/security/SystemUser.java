package com.ifpe.semanainfo.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.ifpe.semanainfo.model.UserModel;

public class SystemUser extends User {
	/*
	 * metodo
	 * que atrves de herança seta as informações do usuario*/
	
	private UserModel userModel;
	
	private static final long serialVersionUID = 1L;
	
	public SystemUser(UserModel userModel, Collection<? extends GrantedAuthority> authorities) {
		super(userModel.getEmail(), userModel.getPassword(), authorities);
		this.userModel = userModel;
	}

	public UserModel getUserModel() {
		return userModel;
	}
	
	

}
