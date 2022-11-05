package com.trip.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class CompraDTO {

	private Integer id_compra;
	private String destino;
	private Double valor;
	private Integer cliente;
	private Integer pacote;

}
