package com.trip.services;

import java.util.List;
import java.util.Optional;

import com.trip.model.entity.Compra;
import com.trip.model.entity.Pacote;

public interface CompraService {

	Compra salvar(Compra compra);

	void deletar(Compra compra);

	Optional<Compra> buscarPorId(Integer id_compra);

	// void validarPacote(Integer id_pacote);

	Optional<Compra> buscarPorIdCliente(Integer fk_id_cliente);

	List<Compra> buscar(Compra searchCompra);

}
