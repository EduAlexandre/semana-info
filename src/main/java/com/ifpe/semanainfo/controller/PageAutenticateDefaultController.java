package com.ifpe.semanainfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageAutenticateDefaultController {

	@GetMapping({"autenticate","/"})
	public String welCome() {
		return "Autenticate";
	}
}
