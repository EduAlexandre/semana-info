package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ifpe.semanainfo.model.Admin;
import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.repository.GroupsRepository;
import com.ifpe.semanainfo.service.ManagerService;
import com.ifpe.semanainfo.service.SpeakerService;

@Controller
public class AdminController {

	@Autowired
	private GroupsRepository groupRepository;
	
	@Autowired
	private ManagerService serviceManager;
	
	@Autowired
	private SpeakerService serviceSpeaker;
		
	@GetMapping("/admin/novo")
	public ModelAndView add(Admin admin) {
		ModelAndView mv = new ModelAndView("admin/home");
		//mv.addObject("groups", groupRepository.findAll());
		
		mv.addObject("listManager", serviceManager.listAll());
		
		mv.addObject("listSpeaker", serviceSpeaker.listAll());
		
		Manager manager = new Manager();
		mv.addObject("manager", manager);
		return mv;		
		
    }
	
	
}
