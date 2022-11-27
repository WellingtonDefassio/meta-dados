package org.estoque.api.dao;

import org.estoque.api.modelo.Produto;

import java.util.Arrays;
import java.util.List;

public class ProdutoDaoMock implements ProdutoDao {
	private static final List<Produto> LISTA_PRODUTO =
			Arrays.asList(new Produto("Produto 1", 20.0, "Marca 1"),
					new Produto("Produto 2", 30.0, "Marca 1"),
					new Produto("Produto 3", 40.0, "Marca 2"),
					new Produto("Produto 2", 20.0, "Marca 3"),
					new Produto("Produto 2", 200.0, "Marca 3"),
					new Produto("Produto 1", 220.0, "Marca 3"),
					new Produto("Produto 2", 210.0, "Marca 3"),
					new Produto("Produto 3", 240.0, "Marca 3"),
					new Produto("Produto 3", 230.0, "Marca 3")



			);
	
	public List<Produto> lista() {
		return LISTA_PRODUTO;
	}
	
	public Produto getProduto(Integer id) {
		return LISTA_PRODUTO.get(id);
	}
}
