package com.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginCtrl {

	@GetMapping("/login.html")
	public String getLogin(Model model) {
		return "login";
	}

}