package com.ifpe.semanainfo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifpe.semanainfo.model.UserModel;




@Controller
public class ManagerController {
	
	@GetMapping("/manager")
	public String showHome(Model model) {
		
		UserModel speaker = new UserModel();
		model.addAttribute("speaker", speaker);
		
		return "/manager/home";
	}
	
	@GetMapping("/deleteM/{idManager}")
	public String delete(@PathVariable("idManager") Integer idManager) {
		
		
		return "redirect:/admin/novo";
	}
}
