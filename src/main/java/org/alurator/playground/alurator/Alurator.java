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
		String nomeMetodo = new Request(url).getNomeMetodo();

		Reflexao reflexao = new Reflexao();

		Object invocaObject = reflexao.reflete(pacote + "." + nomeControle)
				.getContrutorPadrao()
				.invoca();

		Object invocaMethod = reflexao.reflete(pacote + "." + nomeControle).getMethodoPadraoo(nomeMetodo).invoca(invocaObject);
		Object invoca = reflexao.reflete(pacote + "." + nomeControle).criaInstancia().getMetodo(nomeMetodo).invoca();


		System.out.println(invocaObject);
		System.out.println(invocaMethod);
		System.out.println(invoca);

		return invocaObject;

	}

}
