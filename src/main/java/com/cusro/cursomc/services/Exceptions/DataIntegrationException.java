package com.cusro.cursomc.services.Exceptions;

public class DataIntegrationException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DataIntegrationException(String ex) {
		super(ex);
	}

	public DataIntegrationException(String ex, Throwable exx) {
		super(ex,exx);
	}
	
}
