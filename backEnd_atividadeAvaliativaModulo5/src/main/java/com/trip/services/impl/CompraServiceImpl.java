package com.trip.services.impl;

import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.trip.exception.RegraException;
import com.trip.model.entity.Compra;
import com.trip.model.entity.Pacote;
import com.trip.repositories.CompraRepo;
import com.trip.repositories.PacoteRepo;
import com.trip.services.CompraService;

@Repository
public class CompraServiceImpl implements CompraService {

	@Autowired
	private CompraRepo repository;

	@Autowired
	private PacoteRepo repoPacote;

	@Override
	@Transactional
	public Compra salvar(Compra compra, Pacote pacote) {
		validarPacote(pacote.getId_pacote());
		return repository.save(compra);
	}

	@Override
	@Transactional
	public void deletar(Compra compra) {
		Objects.requireNonNull(compra.getId_compra());
		repository.delete(compra);
	}

	@Override
	public Optional<Compra> buscarPorId(Integer id_compra) {
		return repository.findById(id_compra);
	}

	@Override
	public void validarPacote(Integer id_pacote) {
		boolean exists = repoPacote.existsById(id_pacote);
		if (exists) {
			throw new RegraException("Opa, ID inexistente! Pacote não encontrado.");
		}
	}

	@Override
	public Optional<Compra> buscarPorIdCliente(Integer fk_id_cliente) {
		return repository.findById(fk_id_cliente);
	}

}
