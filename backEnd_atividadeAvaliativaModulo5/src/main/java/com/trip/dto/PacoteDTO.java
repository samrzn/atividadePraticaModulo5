package com.trip.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class PacoteDTO {

	private Integer id_pacote;
	private String destino;
	private Double valor;
	private String data_viagem;

}
