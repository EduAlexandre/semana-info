package com.ifpe.semanainfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.model.Speaker;
import com.ifpe.semanainfo.service.ManagerService;
import com.ifpe.semanainfo.service.SpeakerService;


@Controller
public class AdminController {

	@Autowired
	private ManagerService serviceManager; 
	
	@Autowired
	private SpeakerService speakerManager; 
	
	
	@GetMapping("/admin")
	public String showAdminHome(Model model){
		Manager manager = new Manager();
		model.addAttribute("manager", manager);
		
		List<Manager> listManager = serviceManager.listAll();
		model.addAttribute("listManager", listManager);
		
		List<Speaker> listSpeaker = speakerManager.listAll();
		model.addAttribute("listSpeaker", listSpeaker);
		
		return "/admin/home";
	}
	
} 
