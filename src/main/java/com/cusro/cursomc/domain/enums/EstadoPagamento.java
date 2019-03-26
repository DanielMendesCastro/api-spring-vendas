package com.cusro.cursomc.domain.enums;

public enum EstadoPagamento {

	PENDENTE(1,"Pendente"),
	QUITADO(2,"Quitado"),
	CANCELADO(3,"Cancelado");
	

	private int cod;
	private String descricao;

	private EstadoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public Integer getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public static EstadoPagamento ToEnum(Integer cod) {
		
		if(cod.equals(null))
			return null;
		
	    for (EstadoPagamento x  : EstadoPagamento.values())
	    	if(cod  == x.getCod())
	    		return x;
	    
	    throw new IllegalArgumentException("Id Invalido id: " + cod);
		
	}
}
