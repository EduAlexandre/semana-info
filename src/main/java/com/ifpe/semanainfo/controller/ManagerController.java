package com.ifpe.semanainfo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifpe.semanainfo.model.Speaker;
import com.ifpe.semanainfo.service.ManagerService;




@Controller
public class ManagerController {

	
	@Autowired
	private ManagerService managerService;
	
	@GetMapping("/manager")
	public String showHome(Model model) {
		
		Speaker speaker = new Speaker();
		model.addAttribute("speaker", speaker);
		
		return "/manager/home";
	}
	
	@GetMapping("/deleteM/{idManager}")
	public String delete(@PathVariable("idManager") Integer idManager) {
		
		managerService.delete(idManager);
		
		return "redirect:/admin/novo";
	}
}
