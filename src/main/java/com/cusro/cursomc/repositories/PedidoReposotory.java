package com.cusro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cusro.cursomc.domain.Pedido;

@Repository
public interface  PedidoReposotory  extends JpaRepository<Pedido, Integer> {

}
