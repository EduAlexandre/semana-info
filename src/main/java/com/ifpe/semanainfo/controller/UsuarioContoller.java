package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.AdminService;
import com.ifpe.semanainfo.service.GroupsService;

@Controller
public class UsuarioContoller {
	
	@Autowired
	private GroupsService groupService;
	
	@Autowired
	private AdminService adminService;

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
	
	@GetMapping("/recuperar")
	public String showRe() {
		
		return "/RecuperarSenha";
	}
	
	
	@RequestMapping(value = "/verificationCPF", method = RequestMethod.POST)
	@ResponseBody
	public String valideCpf(@RequestParam(name = "cpf") String cpf) {

		Boolean cpfChecado = adminService.verificaCPF(cpf) == null;
		
		return cpfChecado.toString();
		
	}
	
	@RequestMapping(value = "/verificationEmail", method = RequestMethod.POST)
	@ResponseBody
	public String valideEmail(@RequestParam(name = "email") String email) {
		
		Boolean emailChecado = adminService.verificaEmail(email) == null; 
		
		return emailChecado.toString();
		
		
	}
}
