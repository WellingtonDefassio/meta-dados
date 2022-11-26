package org.alurator.playground.controle;

import java.util.List;

public class Controle {
	private List<String> lista = List.of("item 1", "item 2", "item 3");
	
	public List<String> getLista() {
		return lista;
	}


	public Controle() {
	}

	private Controle(String s, String t){}


	private void metodoControle1(){
		System.out.println("Executando metodo private e retorno void parametros vazio metodoControle1()");
	}

}
