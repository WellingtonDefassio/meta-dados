package org.estoque.api.dao;

import org.estoque.api.modelo.Produto;

import java.util.List;

public interface ProdutoDao {
	public List<Produto> lista();
	public Produto getProduto(Integer id);
}
