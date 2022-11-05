package com.trip.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pacote")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pacote {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_pacote;

	@Column
	private String destino;

	@Column
	private Double valor;

	@Column
	private String data_viagem;

	public void setPacote(Pacote pacote) {

	}

}
