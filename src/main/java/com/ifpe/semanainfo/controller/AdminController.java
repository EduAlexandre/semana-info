package com.ifpe.semanainfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.service.ManagerService;


@Controller
public class AdminController {

	@Autowired
	private ManagerService serviceManager; 
	
	
	@GetMapping("/admin")
	public String showAdminHome(Model model){
		Manager manager = new Manager();
		model.addAttribute("manager", manager);
		
		List<Manager> listManager = serviceManager.listAll();
		model.addAttribute("listManager", listManager);
		
		return "/admin/home";
	}
	
} 
