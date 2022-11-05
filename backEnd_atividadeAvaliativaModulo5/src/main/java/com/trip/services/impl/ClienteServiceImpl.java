package com.trip.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trip.exception.AutenticacaoException;
import com.trip.exception.RegraException;
import com.trip.model.entity.Cliente;
import com.trip.repositories.ClienteRepo;
import com.trip.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepo repository;

	@Override
	public Cliente autenticar(String email, String senha) {
		Optional<Cliente> cliente = repository.findByEmail(email);

		if (!cliente.isPresent()) {
			throw new AutenticacaoException("Usuário não encontrado.");
		}
		if (!cliente.get().getSenha().equals(senha)) {
			throw new AutenticacaoException("Senha incorreta.");
		}

		return cliente.get();

	}

	@Override
	@Transactional
	public Cliente salvarCliente(Cliente cliente) {
		validarEmail(cliente.getEmail());
		return repository.save(cliente);
	}

	@Override
	public void validarEmail(String email) {
		boolean exists = repository.existsByEmail(email);
		if (exists) {
			throw new RegraException(
					"Opa, e-mail inválido! Existe uma conta de usuário em nossa plataforma com este endereço eletrônico.");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> buscar(Cliente clienteSearch) {
		Example<Cliente> exemplo = Example.of(clienteSearch,
				ExampleMatcher.matching().withIgnoreCase().withStringMatcher(StringMatcher.CONTAINING));
		return repository.findAll(exemplo);
	}

	@Override
	public Optional<Cliente> buscarPorId(Integer id_cliente) {
		return repository.findById(id_cliente);
	}

}
