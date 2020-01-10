package com.ifpe.semanainfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.semanainfo.model.Manager;
import com.ifpe.semanainfo.model.Room;
import com.ifpe.semanainfo.service.RoomService;



@Controller
public class RoomController {
	
	@Autowired
	private RoomService roomService;
	
	@GetMapping("cadastroSala")
	public String roomRegistration(Room room, Model model){
		model.addAttribute("room", room);
		return"teste";
	}
	@PostMapping("/salvaSala")
	public String saveRoom(Room room, Model model){
		this.roomService.saveRoom(room);
		Manager manager = new Manager();
		model.addAttribute("manager", manager);
		return"/index";
	}
	
	
}
