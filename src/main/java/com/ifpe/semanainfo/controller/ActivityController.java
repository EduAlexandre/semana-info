package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.ActivityService;

@Controller
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/cadastroAtividade")
	public String roomRegistration(Activity activity, Model model){
		model.addAttribute("activity", activity);
		return "/teste";
	}
	
	@PostMapping("/salvaAtividade")
	public String saveRoom(Activity activity, Model model){
		this.activityService.saveActivity(activity);
		UserModel manager = new UserModel();
		model.addAttribute("manager", manager);
		return "/index";
	}

}
