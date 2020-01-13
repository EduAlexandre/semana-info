package com.ifpe.semanainfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ifpe.semanainfo.model.Participant;
import com.ifpe.semanainfo.service.ParticipantService;

@Controller
public class ParticipantController {

		@Autowired  
		private ParticipantService participantservice;
		
		@GetMapping("/cadParticipant")
		public String showCadPar(Model model) {
			Participant participant = new Participant();
			model.addAttribute("participant", participant);
			
			return "/participant/RegisterParticipant";
		} 
		
		@PostMapping("/saveParticipant")
		public String saveParticipant(Participant participant) {
			
			participantservice.save(participant);
			
			return "/participant/editParticipant";
		}
		
		
		@GetMapping("/listParticipant")
		public String list(Model model) {
			List<Participant> list= participantservice.listAll();
			model.addAttribute("participant", list);
			
			return "/participant/ListParticipant.html";
		}
		
		
		@GetMapping("/editeP/{idParticipant}")
		public String edite(@PathVariable("idParticipant") Integer idParticipant,Model model) {

			Participant participant = participantservice.get(idParticipant);
			model.addAttribute("participant", participant);
			
			return "redirect:/editParticipant";
		}
}
