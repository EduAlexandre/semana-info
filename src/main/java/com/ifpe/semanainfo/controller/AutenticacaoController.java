package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.AdminService;

@Controller
@RequestMapping("/usuarios")
public class AutenticacaoController {
	
	@Autowired
	private AdminService serviceAdmin;
	
	@GetMapping("/confirmacao/{id}")
	public String authUsuario(@PathVariable Long id, UserModel manager,Model model) {
		
		
		return "/login";
	}
	
	@GetMapping("/participante/{id}")
	public String authUsuario1(@PathVariable Long id) {
		
		if(id != null) {
			UserModel user = serviceAdmin.searchGetUser(id);
			
			serviceAdmin.updateStatus(user);
			
			return "redirect:/login";
		}
		return "redirect:/cadastro";
	}
	
}
