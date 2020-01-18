package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.service.ActivityService;

@Controller
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@PostMapping("/activitySave")
	public String saveRoom(Activity activity, Model model){
		
		activityService.saveActivity(activity);

		return "redirect:/manager";
	}

}
