package com.trip.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trip.model.entity.Pacote;
import com.trip.repositories.PacoteRepo;
import com.trip.services.PacoteService;

@Service
public class PacoteServiceImpl implements PacoteService {

	@Autowired
	private PacoteRepo repository;

	@Override
	public Optional<Pacote> buscarPorId(Integer id_pacote) {
		return repository.findById(id_pacote);
	}

	@Override
	public List<Pacote> findAll() {
		return repository.findAll();
	}
}
