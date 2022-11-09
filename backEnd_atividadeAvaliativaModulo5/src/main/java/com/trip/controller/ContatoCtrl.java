package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContatoCtrl {

	@GetMapping("/contato.html")
	public String getContato(Model model) {
		return "contato";
	}

}
