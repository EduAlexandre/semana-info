package com.ifpe.semanainfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.model.Registrations;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.ActivityService;
import com.ifpe.semanainfo.service.GroupsService;

@Controller
public class UsuarioContoller {
	
	@Autowired
	private GroupsService groupService;


	@Autowired
	private ActivityService activityService;


	@GetMapping("/user")
	public String showHomeUser(Model model){
		
		List<Activity> activity = activityService.listActivity();
		model.addAttribute("activitys", activity);
		
		Registrations registrations = new Registrations();
		model.addAttribute("registrations", registrations);
		
		return "user/home";
	}
	
	@GetMapping("/cadastro")
	public String cad(Model model) { 
		
		UserModel usuario = new UserModel();
		model.addAttribute("usuario",usuario);
		
		Groups groups = groupService.get(4L);
		model.addAttribute("groups", groups);
		return "cadastro_alu";
	}	
	
	
	@GetMapping("/recuperar")
	public String showRe() {
		
		return "RecuperarSenha";
	
	}
	
	
	@GetMapping("/palestra/{id}")
	public String showMy(Model model,@PathVariable("id")Integer id) {
		List<Activity> registrations = activityService.pickAllForUser(id);
		model.addAttribute("activitys", registrations);
		System.out.println(registrations.toString());
		return "user/listMyActivitys";
	}
	

}
