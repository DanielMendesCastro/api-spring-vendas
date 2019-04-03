package com.cusro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import com.cusro.cursomc.domain.Cliente;
import com.cusro.cursomc.repositories.ClienteRepository;
import com.cusro.cursomc.services.Exceptions.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}
	
	public Cliente update(Cliente obj) {
		Cliente cli  = find(obj.getId());
		UpdateData(cli, obj);
		return repository.save(obj) ;
	}

	public void delete(Integer id) {
		try {
			repository.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new ObjectNotFoundException("Cliente vincula a produtos");
		}
		
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}	
	
	public Page<Cliente> fidPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest paginacao = PageRequest.of(page, linesPerPage, Direction.valueOf(direction),orderBy);		
		return repository.findAll(paginacao);			
	}
	
	public void UpdateData(Cliente clienteNovo, Cliente clienteAntigo) {
	clienteNovo.setNome(clienteAntigo.getNome());
	clienteNovo.setEmail(clienteAntigo.getEmail());
	}
}
