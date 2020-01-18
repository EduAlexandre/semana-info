package com.ifpe.semanainfo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ifpe.semanainfo.model.Activity;
import com.ifpe.semanainfo.model.Groups;
import com.ifpe.semanainfo.model.Room;
import com.ifpe.semanainfo.model.UserModel;
import com.ifpe.semanainfo.service.ActivityService;
import com.ifpe.semanainfo.service.AdminService;
import com.ifpe.semanainfo.service.GroupsService;
import com.ifpe.semanainfo.service.RoomService;




@Controller
public class ManagerController {
	
	@Autowired
	private GroupsService groupService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private RoomService roomService;
	
	@Autowired
	private ActivityService activityService;
	
	@GetMapping("/manager")
	public String showHome(Model model) {
		
		List<Activity> activitys = activityService.listActivity();
		model.addAttribute("activitys", activitys);
		return "/manager/home";
	}
	
	@GetMapping("/palestrante/novo")
	public String cadPales(Model model) {
		
		UserModel speaker = new UserModel();
		model.addAttribute("speaker", speaker);
		
		Groups groups = groupService.get(3L);
		model.addAttribute("groups", groups);
		
		return "/manager/cadGestor";
		
	}
	
	@GetMapping("/palestra/nova")
	public String cadPalestra(Model model) {
		
		Activity activity = new Activity();
		model.addAttribute("activity", activity);
		
		List<UserModel> speakers = adminService.PickASpeakes(3L);
		model.addAttribute("speakers", speakers);
		
		List<Room> rooms = roomService.listAll();
		model.addAttribute("rooms", rooms);
		
		return "/manager/cadPalestra";
	}
}
