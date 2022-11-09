package com.trip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.CompraDTO;
import com.trip.exception.RegraException;
import com.trip.model.entity.Cliente;
import com.trip.model.entity.Compra;
import com.trip.model.entity.Pacote;
import com.trip.services.ClienteService;
import com.trip.services.CompraService;
import com.trip.services.PacoteService;

@RestController
@RequestMapping("trip/compras")
public class CompraController {

	@Autowired
	private CompraService service;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private PacoteService pacoteService;

	@PostMapping
	public ResponseEntity salvar(@RequestBody CompraDTO dto) {
		try {
			Compra entidade = converter(dto);
			entidade = service.salvar(entidade);
			return new ResponseEntity(entidade, HttpStatus.CREATED);
		} catch (RegraException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping("/pesquisar/{id_compra}")
	public ResponseEntity compraPorId(@PathVariable Integer id_compra) {
		Optional<Compra> compra = service.buscarPorId(id_compra);
		return ResponseEntity.ok().body(compra);
	}

	@GetMapping
	public ResponseEntity buscarCompra(@RequestParam(value = "destino", required = false) String destino,
			@RequestParam(value = "valor", required = false) Double valor,
			@RequestParam("fk_id_cliente") Integer fk_id_cliente) {
		Compra searchCompra = new Compra();
		searchCompra.setDestino(destino);
		searchCompra.setValor(valor);

		Optional<Cliente> cliente = clienteService.buscarPorId(fk_id_cliente);
		if (!cliente.isPresent()) {
			return ResponseEntity.badRequest().body("Cliente não encontrado.");
		} else {
			searchCompra.setCliente(cliente.get());
		}

		List<Compra> compra = service.buscar(searchCompra);
		return ResponseEntity.ok(compra);
	}

	private Compra converter(CompraDTO dto) {
		Compra compra = new Compra();
		compra.setId_compra(dto.getId_compra());
		compra.setDestino(dto.getDestino());
		compra.setValor(dto.getValor());

		Cliente cliente = clienteService.buscarPorId(dto.getCliente())
				.orElseThrow(() -> new RegraException("Usuário ID " + dto.getCliente() + " não encontrado."));

		Pacote pacote = pacoteService.buscarPorId(dto.getPacote())
				.orElseThrow(() -> new RegraException("Pacote ID " + dto.getPacote() + " não encontrado."));

		compra.setCliente(cliente);

		compra.setPacote(pacote);

		return compra;

	}

}
