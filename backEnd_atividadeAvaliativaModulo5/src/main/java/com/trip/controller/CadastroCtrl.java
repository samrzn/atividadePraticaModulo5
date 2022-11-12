package com.trip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.trip.model.entity.Cliente;
import com.trip.repositories.ClienteRepo;

@Controller
@RequestMapping("/cadastro")
public class CadastroCtrl {

	@Autowired
	private ClienteRepo service;	
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@GetMapping
	public String obterTodos(Model model) {
		List<Cliente> clientes = service.findAll();
		model.addAttribute("clientes", clientes);
		return "cadastro";
	}

	@GetMapping("incluir")
	public String iniciarInclusao(Model model) {
		model.addAttribute("cliente", new Cliente());
		return "cadastro";
	}

	@PostMapping("incluir")
	public String finalizarInclusao(Model model, @Validated Cliente cliente) {
		cliente.setSenha(passwordEncoder().encode(cliente.getSenha()));
		service.save(cliente);
		return obterTodos(model);
	}

}