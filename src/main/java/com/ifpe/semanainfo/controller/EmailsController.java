package com.ifpe.semanainfo.controller;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.email.MailerSpeaker;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.AdminService;
import com.ifpe.semanainfo.service.SpeakerService;

@Controller
public class EmailsController {
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private AdminService  adminService;
	
	@Autowired
	private MailerSpeaker mailSpeaker;
	
	@PostMapping("/emailManager")
	public String envMailManager(UserModel manager,RedirectAttributes ra) {
		
		return "redirect:/admin/novo";
	}
	
	@PostMapping("/emailSpeaker")
	public String envMailSpeaker(UserModel speaker,RedirectAttributes ra) {
		
		speakerService.save(speaker);
		
		mailSpeaker.enviar(speaker);
		
		return "redirect:/manager";
	}
	
	@PostMapping("/emailUser")
	public String envMailUser(UserModel user,RedirectAttributes ra) {
		
		adminService.saveUser(user);
		
		return "redirect:/login";
	}
}
