package com.trip.services;

import java.util.List;
import java.util.Optional;

import com.trip.model.entity.Pacote;

public interface PacoteService {

	Optional<Pacote> buscarPorId(Integer id_pacote);

	List<Pacote> findAll();
	
}
