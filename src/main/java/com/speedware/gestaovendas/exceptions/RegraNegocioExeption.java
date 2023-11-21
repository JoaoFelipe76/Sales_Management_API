package com.speedware.gestaovendas.exceptions;

public class RegraNegocioExeption extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public RegraNegocioExeption(String messagem) {
		
		super(messagem);
	}

}
