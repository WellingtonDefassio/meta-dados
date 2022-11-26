package org.alurator.playground.alurator.protocolo;

public class Request {

	private String nomeControle;

	public Request(String url) {

        String resultado = url;
        if (url.startsWith("/")) {
            resultado = url.replaceFirst("/", "");
        }
        String[] split = resultado.split("/");

		nomeControle = split[0].substring(0, 1).toUpperCase() + split[0].substring(1) + "Controller";

    }

	public String getNomeControle() {
		return nomeControle;
	}
}
