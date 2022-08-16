package com.softtek.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
//Excepcion que se lanza cuando no existe/encuentra la clase modelo a que esta llamando
public class ModeloNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
	
}
