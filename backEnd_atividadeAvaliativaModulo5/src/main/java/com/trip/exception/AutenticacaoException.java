package com.trip.exception;

public class AutenticacaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AutenticacaoException(String mensagem) {
		super(mensagem);
	}

}
