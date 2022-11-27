package org.estoque.api.controle;

import org.estoque.api.dao.ProdutoDao;
import org.estoque.api.dao.ProdutoDaoMock;
import org.estoque.api.modelo.Produto;

import java.util.List;
import java.util.stream.Collectors;

public class ProdutoController {
	
	private ProdutoDao produtoDao;

	public ProdutoController(ProdutoDao produtoDao) {
		this.produtoDao = produtoDao;
	}
	
	public List<Produto> lista() {
		return produtoDao.lista();
	}
	
	public List<Produto> filtra(String nome) {
		return produtoDao.lista().stream()
							.filter(produto -> produto.getNome().toLowerCase().startsWith(nome.toLowerCase()))
							.collect(Collectors.toList());
	}
	
	public List<Produto> filtra(String nome, String marca) {
		return produtoDao.lista().stream()
							.filter(produto -> 
								produto.getNome().toLowerCase().startsWith(nome.toLowerCase())
								&& produto.getMarca().equalsIgnoreCase(marca)
							)
							.collect(Collectors.toList());
	}
}
