package org.alurator.playground.controle;

import java.io.IOException;
import java.util.List;

public class Controle2 {
	private List<String> lista = List.of("item 1", "item 2", "item 3");

	public List<String> getLista() {
		return lista;
	}


	public Controle2() throws IOException {
		throw new IOException();
	}

	private Controle2(String s, String t){}


}
