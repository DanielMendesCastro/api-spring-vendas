package com.cusro.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cusro.cursomc.domain.Categoria;
import com.cusro.cursomc.domain.Produto;
import com.cusro.cursomc.repositories.CategoriaRepository;
import com.cusro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private ProdutoRepository repoProduto;
	
	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat = new Categoria(null,"Informatica"); 
		Categoria cat2 = new Categoria(null,"Escritorio");
		
		
		Produto p1 = new Produto(null,"Computador",2000D);
		Produto p2 = new Produto(null,"Impressora 800",150D);
		Produto p3 = new Produto(null,"Mouse 80",35D);
		
		cat.setProdutos(Arrays.asList(p1,p2,p3));
		cat2.setProdutos(Arrays.asList(p2));	
		
		p1.setCategorias(Arrays.asList(cat));;
		p2.setCategorias(Arrays.asList(cat,cat2)); ;
		p3.setCategorias(Arrays.asList(cat));
		
		repo.saveAll(Arrays.asList(cat,cat2));
		repoProduto.saveAll(Arrays.asList(p1,p2,p3));
		
	}

}
	