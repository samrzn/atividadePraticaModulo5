package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroCtrl {

	@GetMapping("/cadastro.html")
	public String getCadastro(Model model) {
		return "cadastro";
	}

}