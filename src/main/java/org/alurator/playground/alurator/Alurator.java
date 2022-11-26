package org.alurator.playground.alurator;

import org.alurator.playground.alurator.protocolo.Request;
import org.alurator.playground.alurator.reflexao.Reflexao;

public class Alurator {

	private String pacote;

	public Alurator(String pacote) {

		this.pacote = pacote;
	}

	public Object executa(String url) {
		String nomeControle = new Request(url).getNomeControle();


		Object invoca = new Reflexao()
				.reflete(pacote + "." + nomeControle)
				.getContrutorPadrao()
				.invoca();

		System.out.println(invoca);
		return invoca;

	}

}
