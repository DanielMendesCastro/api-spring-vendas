package com.cusro.cursomc.resources;


import static java.util.stream.Collectors.toList;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cusro.cursomc.domain.Cliente;
import com.cusro.cursomc.domain.Cliente;
import com.cusro.cursomc.dto.ClienteDTO;
import com.cusro.cursomc.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResources {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable int id) {		
		Cliente obj = service.find(id);		
		return ResponseEntity.ok(obj);
	}
	
	@RequestMapping(value = "/Page", method = RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value="page",defaultValue="0")Integer page, 
			@RequestParam(value="linesPerPage",defaultValue="24")Integer linesPerPage, 
			@RequestParam(value="orderBy",defaultValue="nome")String orderBy, 
			@RequestParam(value="direction",defaultValue="DESC")String direction) {		
		Page<Cliente> lista = service.fidPage(page, linesPerPage, direction,orderBy);
		
		return ResponseEntity
				.ok(lista.map(obj -> new ClienteDTO(obj.getId(), obj.getNome(),obj.getEmail())));
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll() {
		List<Cliente> lista = service.findAll();
		return ResponseEntity
				.ok(lista.stream().map(obj -> new ClienteDTO(obj.getId(), obj.getNome(),obj.getEmail())).collect(toList()));
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDTO, @PathVariable Integer id) {
		service.update(objDTO.fromCliente());
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		find(id);
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
