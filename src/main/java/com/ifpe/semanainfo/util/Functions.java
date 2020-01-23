package com.ifpe.semanainfo.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.time.Duration;
import java.time.LocalTime;

public class Functions {
	
	public static String getSHA256(String input){

		String toReturn = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-256");
		    digest.reset();
		    digest.update(input.getBytes("utf8"));
		    toReturn = String.format("%064x", new BigInteger(1, digest.digest()));
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		return toReturn;
	}

	
	public static String duracao(String horainicio,String horafinal) {
		
		String[] hinicio = horainicio.split(":");
		String[] hfinal = horafinal.split(":");
		
		int hora1 = Integer.parseInt(hinicio[0]);
		int minuto1 = Integer.parseInt(hinicio[1]);
		
		int hora2 = Integer.parseInt(hfinal[0]);
		int minuto2 = Integer.parseInt(hfinal[1]);
		
		LocalTime ini = LocalTime.of(hora1, minuto1);
	    LocalTime fim = LocalTime.of(hora2, minuto2);

		Duration duracao = Duration.between(ini, fim);
		
		String result = ""+duracao;
		
		String[] teste = result.split("");
		
		if(teste.length >= 6) {
			result = teste[2]+"h e "+teste[4]+teste[5]+"m";
			return result;
		}else {
			result = teste[2]+"h";
			return result;
		}
		
	}
}
