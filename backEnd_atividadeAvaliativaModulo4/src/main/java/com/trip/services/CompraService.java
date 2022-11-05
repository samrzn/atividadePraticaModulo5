package com.trip.services;

import java.util.Optional;

import com.trip.model.entity.Compra;
import com.trip.model.entity.Pacote;

public interface CompraService {

	Compra salvar(Compra compra, Pacote pacote);

	void deletar(Compra compra);

	Optional<Compra> buscarPorId(Integer id_compra);

	void validarPacote(Integer id_pacote);

}
