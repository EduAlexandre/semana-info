package com.ifpe.semanainfo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.service.AuteticationService;
import com.ifpe.semanainfo.service.ManagerService;




@Controller
public class ManagerController {

	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private AuteticationService auteService;
	
	@GetMapping("/cadManager")
	public String showCad(Model model) {
		Manager manager = new Manager();
		model.addAttribute("manager", manager);
		
		return "/manager/cadManager";
	}
	
	@PostMapping("/saveManager")
	public String saveManager(Manager manager,RedirectAttributes ra) {
		
		auteService.autenciaUsuario(manager);
		
		ra.addFlashAttribute("mensagemErro", "4");
		
		return "redirect:/";
	}
	
	
	@GetMapping("/editeM/{idManager}")
	public String edite(@PathVariable("idManager") Integer idManager,Model model) {

		Manager manager = managerService.get(idManager);
		model.addAttribute("manager", manager);
		
		return "/manager/editManager";
	}
	
	@GetMapping("/deleteM/{idManager}")
	public String delete(@PathVariable("idManager") Integer idManager) {
		
		managerService.delete(idManager);
		
		return "redirect:/admin";
	}
}
