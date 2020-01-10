package com.ifpe.semanainfo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ifpe.semanainfo.email.EmailIsPresentException;
import com.ifpe.semanainfo.model.Speaker;
import com.ifpe.semanainfo.repository.Speaks;
import com.ifpe.semanainfo.service.SpeakerService;


@Controller
@RequestMapping("palestrante")
public class SpeakerController {
	
	@Autowired
	private SpeakerService speakerService;
	
	@Autowired
	private Speaks speaks;

	
	@RequestMapping("/novo")
	public ModelAndView newSpeaker(Speaker speaker) {
	  ModelAndView mv = new ModelAndView("speaker/RegisterSpeaker");	
	  return mv;	
	}
	
	@RequestMapping(value = { "/novo", "{\\d+}" }, method = RequestMethod.POST)
	public ModelAndView register(@Valid Speaker speaker, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {			
		   return newSpeaker(speaker);	
		}
		
		try {
			speakerService.register(speaker);	
		} catch (EmailIsPresentException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return newSpeaker(speaker);	
		}
		
		
		attributes.addFlashAttribute("message", "Adicionado com sucesso"); 
		return new ModelAndView("redirect:/palestrante/novo");
	}
	
	@GetMapping
	public ModelAndView listSpeakes() {
		ModelAndView mv = new ModelAndView("speaker/searchSpeakers");
		mv.addObject("list", speaks.findAll());
		return mv;
	}
	
	@GetMapping("/{cod}")
	public ModelAndView edit(@PathVariable("cod") Speaker speaker) {
		ModelAndView mv = newSpeaker(speaker);
		mv.addObject(speaker);		
		return mv;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
