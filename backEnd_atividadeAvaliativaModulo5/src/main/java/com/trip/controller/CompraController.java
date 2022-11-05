package com.trip.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.CompraDTO;
import com.trip.exception.RegraException;
import com.trip.model.entity.Cliente;
import com.trip.model.entity.Compra;
import com.trip.services.ClienteService;
import com.trip.services.CompraService;

@RestController
@RequestMapping("trip/compras")
public class CompraController {

	@Autowired
	private CompraService service;

	@Autowired
	private ClienteService clienteService;

	@PostMapping
	public ResponseEntity salvar(@RequestBody CompraDTO dto) {
		try {
			Compra entidade = converter(dto);
			entidade = service.salvar(entidade, null);
			return new ResponseEntity(entidade, HttpStatus.CREATED);
		} catch (RegraException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/pesquisar/{id}")
	public ResponseEntity<Optional<Compra>> findById(@PathVariable("id") Integer id_compra) {
		Optional<Compra> compra = service.buscarPorId(id_compra);
		return ResponseEntity.ok().body(compra);
	}

	@GetMapping("{id}")
	public ResponseEntity<Optional<Compra>> findByClient(@PathVariable("id") Integer fk_id_cliente) {
		Optional<Compra> compra = service.buscarPorIdCliente(fk_id_cliente);
		return ResponseEntity.ok().body(compra);
	}

	private Compra converter(CompraDTO dto) {
		Compra compra = new Compra();
		compra.setId_compra(dto.getId_compra());
		compra.setDestino(dto.getDestino());
		compra.setValor(dto.getValor());

		Cliente cliente = clienteService.buscarPorId(dto.getCliente())
				.orElseThrow(() -> new RegraException("Usuário ID " + dto.getCliente() + " não encontrado."));

		compra.setCliente(cliente);

		return compra;

	}

}
