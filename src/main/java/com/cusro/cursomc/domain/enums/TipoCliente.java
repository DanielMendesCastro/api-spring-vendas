package com.cusro.cursomc.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Fisica"), PESSOAJURIDICA(1, "Pessoa Juridica");

	private int cod;
	private String descricao;

	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente ToEnum(Integer cod) {
		
		if(cod.equals(null))
			return null;
		
	    for (TipoCliente x  : TipoCliente.values())
	    	if(cod  == x.getCod())
	    		return x;
	    
	    throw new IllegalArgumentException("Id Invalido id: " + cod);
		
	}
}
