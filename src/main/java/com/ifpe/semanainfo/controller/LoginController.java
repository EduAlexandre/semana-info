package com.ifpe.semanainfo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.model.Admin;
import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.service.AdminService;
import com.ifpe.semanainfo.service.ManagerService;


@Controller
public class LoginController {

	
	@Autowired
	private ManagerService serviceManager;
	
	@Autowired
	private AdminService serviceAdmin;
	
	@GetMapping("/")
	public String showLogin(Model model) {
		Manager manager = new Manager();
		model.addAttribute("manager", manager);
		
		return "index";
	}
	
	@PostMapping("/accomplishLogin")
	public String accomplishLogin(Manager manager , HttpSession session,RedirectAttributes ra) {
		
		Manager  managerCheckend = serviceManager.sarching(manager.getEmail(), manager.getSenha());
		
		if(managerCheckend == null){
			
			Admin adminCheckend = serviceAdmin.sarchingAdmin(manager.getEmail(), manager.getSenha());
			
			if(adminCheckend == null) {
				ra.addFlashAttribute("mensagemErro", "1");
				return "redirect:/";
			}else {
				if(adminCheckend.getPermission() != 4) {
					ra.addFlashAttribute("mensagemErro", "3");
					return "redirect:/admin";
				}else {
					session.setAttribute("adminLogado", adminCheckend);
					return "redirect:/admin";
				}
			}
			
		}else{
			if(managerCheckend.getAtivo() != 1) {
				ra.addFlashAttribute("mensagemErro", "2");
				return "redirect:/";
			}else {
				if(managerCheckend.getPermission() != 3) {
					ra.addFlashAttribute("mensagemErro", "3");
					return "redirect:/";
				}else {
					session.setAttribute("managerLogado", managerCheckend);
					return "/manager/home";
				}
				
			}
		}
		
	}
	
	
	
	
	@GetMapping("/logout")
	public String logUot(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
