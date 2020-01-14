package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifpe.semanainfo.model.Admin;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.GroupsRepository;
import com.ifpe.semanainfo.service.SpeakerService;

@Controller
public class AdminController {

	@Autowired
	private SpeakerService serviceSpeaker;
	
	@Autowired
	private GroupsRepository groupRepository;
		
	@GetMapping("/admin/novo")
	public ModelAndView add(Admin admin) {
		ModelAndView mv = new ModelAndView("admin/home");
		mv.addObject("groups", groupRepository.findAll());
		
		UserModel manager = new UserModel();
		mv.addObject("manager", manager);
		return mv;		
		
    }
	
	
}
