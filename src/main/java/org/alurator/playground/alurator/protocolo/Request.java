package org.alurator.playground.alurator.protocolo;

public class Request {

	private String nomeControle;
    private String nomeMetodo;

	public Request(String url) {

        String resultado = url;
        if (url.startsWith("/")) {
            resultado = url.replaceFirst("/", "");
        }
        String[] split = resultado.split("/");
		nomeControle = split[0].substring(0, 1).toUpperCase() + split[0].substring(1) + "Controller";

        nomeMetodo = split[split.length - 1];
    }

	public String getNomeControle() {
		return nomeControle;
	}

    public String getNomeMetodo() {
        return nomeMetodo;
    }
}
