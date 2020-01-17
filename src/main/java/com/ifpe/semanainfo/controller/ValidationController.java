package com.ifpe.semanainfo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifpe.semanainfo.service.AdminService;

@Controller
public class ValidationController {
	
	
	@Autowired
	private AdminService adminService;

	@GetMapping("/verificationEmail")
	@ResponseBody
	public String valideEmail(@PathParam("email") String email) {
		
		Boolean emailChecado = adminService.verificaEmail(email) == null; 
		
		return emailChecado.toString();
		
		
	}
	
	@GetMapping("/verificationCPF")
	@ResponseBody
	public String valideCpf(@PathParam("cpf") String cpf) {

		Boolean cpfChecado = adminService.verificaCPF(cpf) == null;
		
		return cpfChecado.toString();
		
	}
}
