package com.ifpe.semanainfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifpe.semanainfo.model.Manager;

@Controller
@RequestMapping("/Usuario")
public class AutenticacaoController {
	
	@GetMapping("/Manager/{hash}")
	public String authUsuario(@PathVariable String hash, Manager manager,Model model) {
		
		return "/manager/cadManager";
	}
	
	
}
