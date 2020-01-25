package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.repository.GroupsRepository;
import com.ifpe.semanainfo.service.AdminService;

@Controller
public class AdminController {

	
	@Autowired
	private GroupsRepository groupRepository;
	
	@Autowired
	private AdminService adminService;
		
	@GetMapping("admin/novo")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView("admin/home");
		mv.addObject("groups", groupRepository.findAll());
		
		mv.addObject("listAdmins", adminService.pickUpSomeSpecificGroup(1));
		mv.addObject("listManagers", adminService.pickUpSomeSpecificGroup(2));
		mv.addObject("listSpeakes", adminService.pickUpSomeSpecificGroup(3));
		mv.addObject("listUsers", adminService.pickUpSomeSpecificGroup(4));
		
		UserModel manager = new UserModel();
		mv.addObject("manager", manager);
		return mv;		
		
    }
	
	@GetMapping("deleteAUser/{id}")
	public String delete(@PathVariable("id") Long id) {
		
		adminService.deleteOneUser(id);
		
		return "redirect:admin/novo";
	}
	
	
}
