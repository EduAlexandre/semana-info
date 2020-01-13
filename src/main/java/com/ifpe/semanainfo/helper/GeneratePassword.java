package com.ifpe.semanainfo.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneratePassword {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("a"));
	}

	public static String cripto(String newSenha) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senha = encoder.encode(newSenha);
		return senha;
	}
}
