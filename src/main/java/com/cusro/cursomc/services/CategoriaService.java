package com.cusro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.cusro.cursomc.domain.Categoria;
import com.cusro.cursomc.repositories.CategoriaRepository;
import com.cusro.cursomc.services.Exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {
	
		return repository.save(obj);
	}

	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repository.save(obj) ;
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new ObjectNotFoundException("Categoria vincula a produtos");
		}
		
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	
	public Page<Categoria> fidPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		
		PageRequest paginacao = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);		
		
		return repository.findAll(paginacao);
				
	}
	
}
