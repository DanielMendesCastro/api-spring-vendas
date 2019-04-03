package com.cusro.cursomc.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.NotEmpty;

import com.cusro.cursomc.domain.Categoria;

public class CategoriaDTO  implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	@NotEmpty(message="Preenchimento Obrigatorio")
	@Length(min=5,max = 80,message="O tamanho deve ser entre 5 e 80 caracteres")
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
	
	public Categoria fromCategoria() {
		return new Categoria(id,Nome);
	}
	
}
