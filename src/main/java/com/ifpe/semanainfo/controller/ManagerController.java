package com.ifpe.semanainfo.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.GroupsService;




@Controller
public class ManagerController {
	
	@Autowired
	private GroupsService groupService;
	
	@GetMapping("/manager")
	public String showHome(Model model) {
		
		UserModel speaker = new UserModel();
		model.addAttribute("speaker", speaker);
		
		Groups groups = groupService.get(3L);
		model.addAttribute("groups", groups);
		
		return "/manager/home";
	}
	
}
