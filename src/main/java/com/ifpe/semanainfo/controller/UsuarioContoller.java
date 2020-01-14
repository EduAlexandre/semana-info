package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.GroupsService;

@Controller
public class UsuarioContoller {
	
	@Autowired
	private GroupsService groupService;

	@GetMapping("/cadastro")
	public String cad(Model model) { 
		
		UserModel usuario = new UserModel();
		model.addAttribute("usuario",usuario);
		
		Groups groups = groupService.get(4L);
		model.addAttribute("groups", groups);
		return "/cadastro_alu";
	}
	
	@GetMapping("/user")
	public String showH() {
		
		return "/user/home";
	}
}
