package com.cusro.cursomc.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cusro.cursomc.domain.Categoria;
import com.cusro.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable int id) {
		
		Categoria obj = service.find(id);
		
		return ResponseEntity.ok(obj);
	}

}
