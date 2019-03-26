package com.cusro.cursomc.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cusro.cursomc.domain.Cliente;
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

}
