package com.trip.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.trip.dto.ClienteDTO;
import com.trip.exception.AutenticacaoException;
import com.trip.model.entity.Cliente;
import com.trip.services.ClienteService;

@RestController
@RequestMapping("trip/clientes")
public class ClienteController {

	private ClienteService service;

	@PostMapping("/autenticar")
	public ResponseEntity autenticar(@RequestBody ClienteDTO dto) {
		try {
			Cliente usuarioAutenticado = service.autenticar(dto.getEmail(), dto.getSenha());
			return ResponseEntity.ok(usuarioAutenticado);
		} catch (AutenticacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PostMapping
	public ResponseEntity salvar(@RequestBody ClienteDTO dto) {
		Cliente cliente = Cliente.builder().nome(dto.getNome()).telefone(dto.getTelefone()).email(dto.getEmail())
				.cpf(dto.getCpf()).senha(dto.getSenha()).build();

		try {
			Cliente usuarioSalvo = service.salvarCliente(cliente);
			return new ResponseEntity(usuarioSalvo, HttpStatus.CREATED);
		} catch (AutenticacaoException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@GetMapping
	public ResponseEntity buscar(@RequestParam(value = "nome", required = false) String nome,
			@RequestParam("cliente") Integer id_cliente) {
		Cliente clienteSearch = new Cliente();
		clienteSearch.setNome(nome);
//		clienteSearch.setId_cliente(id_cliente);

		Optional<Cliente> usuario = service.buscarPorId(id_cliente);
		if (!usuario.isPresent()) {
			return ResponseEntity.badRequest().body("Usuário não encontrado.");
		} else {
			clienteSearch.setCliente(usuario.get());
		}

		List<Cliente> cliente = service.buscar(clienteSearch);
		return ResponseEntity.ok(cliente);
	}

}
