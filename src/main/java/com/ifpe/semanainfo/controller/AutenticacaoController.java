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
@RequestMapping("usuarios")
public class AutenticacaoController {
	
	@Autowired
	private AdminService serviceAdmin;
	
	@GetMapping("confirmacao/{id}")
	public String authUsuario(@PathVariable Long id,Model model) {
		
		
		return "/login";
	}
	
	@GetMapping("gestor/{id}")
	public String authManager(@PathVariable Long id) {
		
		if(id != null) {
			UserModel manager = serviceAdmin.searchAndPickAUser(id); 
			
			serviceAdmin.updateStatus(manager);
			
			return "redirect:/login";
		}
		
		return "redirect:login";
	}
	
	@GetMapping("palestrante/{id}")
	public String authSpeaker(@PathVariable Long id) {
		
		if(id != null) {
			UserModel speaker = serviceAdmin.searchAndPickAUser(id); 
			
			serviceAdmin.updateStatus(speaker);
			
			return "redirect:/login";
		}
		return "redirect:/login";
	}
	
	@GetMapping("participante/{id}")
	public String authUsuario(@PathVariable Long id) {
		
		if(id != null) {
			UserModel user = serviceAdmin.searchAndPickAUser(id); 
			
			serviceAdmin.updateStatus(user);
			
			return "redirect:/login";
		}
		return "redirect:/cadastro";
	}
	
	
	
}
