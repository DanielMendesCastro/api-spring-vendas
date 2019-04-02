package com.cusro.cursomc.resources;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;

import org.hibernate.transform.ToListResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import static java.util.stream.Collectors.toList;

import com.cusro.cursomc.domain.Categoria;
import com.cusro.cursomc.dto.CategoriaDTO;
import com.cusro.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable int id) {
		Categoria obj = service.find(id);
		return ResponseEntity.ok(obj);
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<Page<CategoriaDTO>> findAll(
			@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue="nome")String orderBy, 
			@RequestParam(value="direction",defaultValue="DESC")String direction) {
		
		Page<Categoria> lista = service.fidPage(page, linesPerPage, direction,orderBy);
		
		return ResponseEntity
				.ok(lista.map(obj -> new CategoriaDTO(obj.getId(), obj.getNome())));
	}
	
	@RequestMapping(value = "/Page", method = RequestMethod.GET)
	public ResponseEntity<List<CategoriaDTO>> findPage() {
		List<Categoria> lista = service.findAll();
		return ResponseEntity
				.ok(lista.stream().map(obj -> new CategoriaDTO(obj.getId(), obj.getNome())).collect(toList()));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Categoria obj, @PathVariable Integer id) {
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		find(id);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
