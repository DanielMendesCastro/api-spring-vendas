package com.cusro.cursomc.dto;

import java.io.Serializable;

public class CategoriaDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String Nome;
	
	public CategoriaDTO(Integer id, String nome) {
		super();
		this.id = id;
		Nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}	
}
