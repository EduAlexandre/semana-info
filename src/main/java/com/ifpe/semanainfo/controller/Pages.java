package com.ifpe.semanainfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Pages {

	
	@GetMapping("/Home")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/Cadastre-se")
	public String cad() {
		return "cadastro_alu";
	}
	
	
	
}
