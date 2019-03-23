package com.cusro.cursomc.services.Exceptions;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundException(String ex) {
		super(ex);
	}

	public ObjectNotFoundException(String ex, Throwable exx) {
		super(ex,exx);
	}
	
}
