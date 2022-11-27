package org.alurator.playground.alurator.protocolo;

import java.util.HashMap;
import java.util.Map;

public class Request {

	private String nomeControle;
    private String nomeMetodo;

    private Map<String, Object> queryParams;

	public Request(String url) {
        /*
        Casos possiveis:
        controlador/metodo
        controlador/metodo?param1=valor1&param2=valor2

         */
        String[] splitURL = url.split("[?]");
        int length = splitURL.length;
        String stringDestino = splitURL[0];
        String stringParametros = length >= 2 ? splitURL[1] : "";
        if (url.startsWith("/")) {
            stringDestino = url.replaceFirst("/", "");
        }
        String[] split = stringDestino.split("/");
		nomeControle = split[0].substring(0, 1).toUpperCase() + split[0].substring(1) + "Controller";
        nomeMetodo = split[split.length - 1];

        queryParams = !stringParametros.isEmpty() ?
                new QueryParamsBuilder().withParams(stringParametros).build() :
                new HashMap<>();

    }

	public String getNomeControle() {
		return nomeControle;
	}

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public Map<String, Object> getQueryParams() {
        return queryParams;
    }
}
