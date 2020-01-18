package com.ifpe.semanainfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.model.Room;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.ActivityService;
import com.ifpe.semanainfo.service.AdminService;
import com.ifpe.semanainfo.service.RoomService;

@Controller
public class ActivityController {
	@Autowired
	private ActivityService activityService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/activitySave")
	public String saveRoom(Activity activity, Model model){
		
		activityService.saveActivity(activity);

		return "redirect:/manager";
	}
	
	@GetMapping("/editePalestra/{id}")
	public String edite(@PathVariable("id") Integer id ,Model model) {
		
		Activity activity = activityService.get(id);
		model.addAttribute("activity", activity);
		
		List<UserModel> speakers = adminService.PickASpeakes(3L);
		model.addAttribute("speakers", speakers);
		
		List<Room> rooms = roomService.listAll();
		model.addAttribute("rooms", rooms);
		
		return "/manager/edite";
	}
	
	@GetMapping("/deletePalestra/{id}")
	public String excluir(@PathVariable("id") Integer id ) {
		
		activityService.deleteActivity(id);
		
		return "redirect:/manager";
	}

}
