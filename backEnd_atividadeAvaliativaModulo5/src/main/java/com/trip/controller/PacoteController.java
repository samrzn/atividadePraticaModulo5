package com.trip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.model.entity.Pacote;
import com.trip.services.PacoteService;

@RestController
@RequestMapping("pacotes")
public class PacoteController {

	@Autowired
	private PacoteService service;

	@GetMapping
	public ResponseEntity buscar(@RequestParam(value = "destino", required = false) String destino,
			@RequestParam("pacote") Integer id_pacote) {
		Pacote pacoteSearch = new Pacote();
		pacoteSearch.setDestino(destino);
//		pacoteSearch.setId_pacote(id_pacote);

		Optional<Pacote> pacote = service.buscarPorId(id_pacote);
		if (!pacote.isPresent()) {
			return ResponseEntity.badRequest().body("Pacote não encontrado.");
		} else {
			pacoteSearch.setPacote(pacote.get());
		}

		List<Pacote> pkg = service.buscar(pacoteSearch);
		return ResponseEntity.ok(pkg);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Pacote>> findById(@PathVariable("id") Integer id_pacote) {
		Optional<Pacote> pacote = service.buscarPorId(id_pacote);
		return ResponseEntity.ok().body(pacote);
	}
	
	@GetMapping("/todos")
	public ResponseEntity<List<Pacote>> findAll() {
		List<Pacote> pacote = service.findAll();
		return ResponseEntity.ok().body(pacote);
	}

}
