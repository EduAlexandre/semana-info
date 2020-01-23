package com.ifpe.semanainfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.service.ActivityService;


@Controller
public class SpeakerController {

	@Autowired
	private ActivityService activityService;
	
	@GetMapping("speaker")
	public String showHomeSpeaker(Model model) {
		
		List<Activity> activitys = activityService.listActivity();
		model.addAttribute("activitys", activitys);
		
		return "speaker/home";
	}

	@GetMapping("palestra/speaker/{nome}")
	public String showPalestras(Model model,@PathVariable("nome")String nome) {
		
//		List<Activity> activitys = activityService.pickAllForSpeaker(nome);
//		model.addAttribute("activitys", activitys);
		
		return "speaker/listPales";
	}	
}
