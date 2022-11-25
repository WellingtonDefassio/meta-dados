package org.alurator.playground.alurator;

public class Alurator {

	private String pacote;

	public Alurator(String pacote) {

		this.pacote = pacote;
	}

	public Object executa(String url) throws Exception {
		String[] split = ajustaURL(url);
		String classe = getClassNome(split);
		Class<?> aClass = Class.forName(pacote +"."+ classe);
		Object instance = aClass.getConstructor().newInstance();

		return instance;
	}


	private String[] ajustaURL(String url) {
		String resultado = url;
		if(url.startsWith("/")){
			resultado = url.replaceFirst("/", "");
		}
		String[] split = resultado.split("/");

		return split;
	}

	private String getClassNome(String[] split) {
	return split[0].substring(0,1).toUpperCase() + split[0].substring(1) + "Controller";
	}

}
