package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DestinosCtrl {

	@GetMapping("/destinos.html")
	public String getDestino(Model model) {
		return "destinos";
	}

}
