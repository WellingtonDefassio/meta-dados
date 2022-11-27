package org.estoque.api;

import org.alurator.playground.alurator.Alurator;
import org.alurator.playground.alurator.Alurator2;
import org.estoque.api.dao.ProdutoDao;
import org.estoque.api.dao.ProdutoDaoMock;

import java.util.Scanner;

public class Main2 {

	/**
	 * Simula o navegador.
	 * 
	 */
	public static void main(String[] args) throws Exception {
		
		/*
		 * Casos possiveis:
		 * /controlador/metodo
		 * /controlador/metodo?param1=valor1&param2=valor2
		 */
		
		try (Scanner s = new Scanner(System.in)) {
			String url = s.nextLine();
			
			Alurator2 alurator = new Alurator2("org.estoque.api.controle");
			alurator.registra(ProdutoDao.class, ProdutoDaoMock.class);
			while (!url.equals("exit")) {
				Object response = alurator.executa(url);
				
				System.out.println("Response: \n" + response);
				
				url = s.nextLine();
			}
		}
	}

}
