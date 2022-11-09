package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PromoCtrl {

	@GetMapping("/promo.html")
	public String getPromo(Model model) {
		return "promo";
	}

}
