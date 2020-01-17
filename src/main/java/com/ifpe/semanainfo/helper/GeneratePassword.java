package com.ifpe.semanainfo.helper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ifpe.semanainfo.util.PasswordGenerate;

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
	
	public static String generatePass() {
		
		//variaveis para geração de senha
		String ALPHA_CAPS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	    String ALPHA = "abcdefghijklmnopqrstuvwxyz";
	    String NUMERIC = "0123456789";
		Integer len = 6;
		
		return PasswordGenerate.generatePassword(len, ALPHA_CAPS + ALPHA + NUMERIC);
	}
}
