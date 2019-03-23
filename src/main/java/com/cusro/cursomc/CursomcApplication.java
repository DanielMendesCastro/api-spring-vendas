package com.cusro.cursomc;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cusro.cursomc.domain.Categoria;
import com.cusro.cursomc.domain.Cidade;
import com.cusro.cursomc.domain.Cliente;
import com.cusro.cursomc.domain.Endereco;
import com.cusro.cursomc.domain.Estado;
import com.cusro.cursomc.domain.Produto;
import com.cusro.cursomc.domain.enums.TipoCliente;
import com.cusro.cursomc.repositories.CategoriaRepository;
import com.cusro.cursomc.repositories.CidadeRepository;
import com.cusro.cursomc.repositories.EstadoRepository;
import com.cusro.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Autowired
	private CategoriaRepository repo;
	
	@Autowired
	private CidadeRepository repoCidade;
	
	@Autowired
	private EstadoRepository repoEstado;
	
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
		
		Estado est1 = new Estado(null, "Minas Gerais"); 
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlandia",est1);
		Cidade c2 = new Cidade(null,"São Paulo",est2);
		Cidade c3 = new Cidade(null,"Campinas",est2);
		
		est1.setCidades(Arrays.asList(c1));
		est2.setCidades(Arrays.asList(c2,c3));
		
		repo.saveAll(Arrays.asList(cat,cat2));
		repoProduto.saveAll(Arrays.asList(p1,p2,p3));
		repoEstado.saveAll(Arrays.asList(est1,est2));
		repoCidade.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null,"Maria Silva","MariaSilva@gmail.com","43854785422",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll((Arrays.asList("993654874","995487521")));
		
		
		Endereco e1  = new Endereco(null,"Rua Flores",300,"ap 500","Jardim","14402547",cli1,c1);
		Endereco e2 = new Endereco(null, "Rua Matos da Silva", 550, "Ap 402", "Paulista", "14402658", cli1, c2);
		
	}

}
	