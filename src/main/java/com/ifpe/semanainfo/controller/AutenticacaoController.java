package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.service.ManagerService;

@Controller
@RequestMapping("/Usuario")
public class AutenticacaoController {
	
	@Autowired
	private ManagerService managerService;
	
//	@GetMapping("/Manager/{hash}")
//	public String authUsuario(@PathVariable String hash, Manager manager,Model model) {
//		manager.setHashCode(hash);
//		
//		Manager managerObj = managerService.searchingHashCode(manager.getHashCode()); 
//		model.addAttribute("manager", managerObj);
//		
//		return "/manager/cadManager";
//	}
	
	
}
