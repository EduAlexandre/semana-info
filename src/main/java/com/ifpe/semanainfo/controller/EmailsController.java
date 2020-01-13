package com.ifpe.semanainfo.controller;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.email.MailerSpeaker;
import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.model.Speaker;
import com.ifpe.semanainfo.service.ManagerService;
import com.ifpe.semanainfo.service.SpeakerService;

@Controller
public class EmailsController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private MailerSpeaker mailSpeaker;
	
	@PostMapping("/emailManager")
	public String envMail(Manager manager,RedirectAttributes ra) {
		
		managerService.save(manager);
		
		return "redirect:/admin/novo";
	}
	
	@PostMapping("/emailSpeaker")
	public String envMail(Speaker speaker,RedirectAttributes ra) {
		
		speakerService.save(speaker);
		
		mailSpeaker.enviar(speaker);
		
		return "redirect:/admin";
	}
}
