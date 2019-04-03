package com.cusro.cursomc.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cusro.cursomc.services.Exceptions.DataIntegrationException;
import com.cusro.cursomc.services.Exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DataIntegrationException.class)
	public ResponseEntity<StandardError> DataIntegrityException(ObjectNotFoundException e, HttpServletRequest request){
		
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(),e.getMessage(),System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> Validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError error = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Erro de validação",System.currentTimeMillis());
		for(FieldError x :  e.getBindingResult().getFieldErrors())
		 error.addError(x.getField(), x.getDefaultMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
}
