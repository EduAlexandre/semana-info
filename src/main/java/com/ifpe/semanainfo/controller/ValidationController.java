package com.ifpe.semanainfo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ifpe.semanainfo.service.ActivityService;
import com.ifpe.semanainfo.service.AdminService;

@Controller
public class ValidationController {
	
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ActivityService activityService;

	@GetMapping("/verificationEmail")
	@ResponseBody
	public String valideEmail(@PathParam("email") String email) {
		
		Boolean emailChecado = adminService.verificaEmail(email) == null; 
		
		return emailChecado.toString();
		
		
	}
	
	@GetMapping("/verificationCPF")
	@ResponseBody
	public String valideCpf(@PathParam("cpf") String cpf) {

		Boolean cpfChecado = adminService.verificaCPF(cpf) == null;
		
		return cpfChecado.toString();
		
	}
	
	@GetMapping("/verificationTimeIni")
	@ResponseBody
	public String valideTimeIni(@PathParam("time") String time,@PathParam("room") String room) {
		
		Boolean emailChecado = activityService.verificaTimeIni(time,room) == null; 
		
		return emailChecado.toString();
		
		
	}
	
	@GetMapping("/verificationTimeFim")
	@ResponseBody
	public String valideTimeFim(@PathParam("time") String time,@PathParam("room") String room) {
		System.out.println("1111111111------"+ time + "-----11111111111-----"+room);
		Boolean cpfChecado = activityService.verificaTimeFim(time,room) == null;
		System.out.println(cpfChecado);
		return cpfChecado.toString();
		
	}
	
	
	@GetMapping("/verificationTimeSpeaker")
	@ResponseBody
	public String valideTimeSpeaker(@PathParam("time") String time,@PathParam("palestrante") String palestrante) {
System.out.println("1111111111------"+ time + "-----11111111111-----"+palestrante);
		Boolean cpfChecado = activityService.verificaTimeSpeaker(time,palestrante) == null;
		System.out.println(cpfChecado);
		return cpfChecado.toString();
		
	}
}
