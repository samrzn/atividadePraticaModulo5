package com.trip.services;

import java.util.Optional;

import com.trip.model.entity.Cliente;

public interface ClienteService {

	Cliente autenticar(String email, String senha);

	Cliente salvarCliente(Cliente cliente);

	void validarEmail(String email);

	Optional<Cliente> buscarPorId(Integer id_cliente);

}
