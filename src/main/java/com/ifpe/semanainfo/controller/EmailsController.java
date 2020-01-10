package com.ifpe.semanainfo.controller;	

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.email.MailerManager;
import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.service.ManagerService;

@Controller
public class EmailsController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private MailerManager mailManager;
	
	@PostMapping("/emailManager")
	public String envMail(Manager manager,RedirectAttributes ra) {
		
		managerService.save(manager);
		
		mailManager.enviar(manager);
		
		return "redirect:/admin";
	}
}
