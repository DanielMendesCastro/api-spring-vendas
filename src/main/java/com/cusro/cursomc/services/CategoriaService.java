package com.cusro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cusro.cursomc.domain.Categoria;
import com.cusro.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository; 
	
	public Categoria find(int id) {
		Optional<Categoria>  categoria =  repository.findById(id);	
		return categoria.orElse(null);
	}

}
