package com.ifpe.semanainfo.controller;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.AdminService;

@Controller
public class EmailsController {
	
	@Autowired
	private AdminService  adminService;
	
	@PostMapping("/emailManager")
	public String envMailManager(UserModel manager,RedirectAttributes ra) {
		
		adminService.saveManager(manager);
		
		return "redirect:/admin/novo";
	}
	
	@PostMapping("/emailSpeaker")
	public String envMailSpeaker(UserModel speaker,RedirectAttributes ra) {
		
		adminService.saveSpeaker(speaker);
		
		return "redirect:/login";
	}
	
	@PostMapping("/emailUser")
	public String envMailUser(UserModel user ,RedirectAttributes ra) {
		
		adminService.saveUser(user);
		ra.addFlashAttribute("mensagemErro", "4");
		
		return "redirect:/login";
	}
}
