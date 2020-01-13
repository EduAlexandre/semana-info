package com.ifpe.semanainfo.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifpe.semanainfo.security.SystemUser;


@Controller
public class LoginController {	
	
	
	@GetMapping("/login")
	public String showLogin(@AuthenticationPrincipal SystemUser user) {
	   if(user != null) {
		   if(user.getUserModel().getCodGrup() == 1) {
			   return "redirect:/admin/novo";
		   }
		   return "redirect:/403";
	   }
		return "login";
	}
	
	
	@GetMapping("/403")
	public String denyAcsseslogUot() {
		return "403";	
	}

	
	@GetMapping("/multiple")
	public String multipleAcsses() {
		return "multAccess";
	}
	
	
	
	
}
