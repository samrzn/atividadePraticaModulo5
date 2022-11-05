package com.trip.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ClienteDTO {

	private String nome;
	private String telefone;
	private String email;
	private String cpf;
	private String senha;

}
