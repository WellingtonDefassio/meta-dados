package org.alurator.playground.alurator.reflexao;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.stream.Stream;

public class ManipuladorObjeto {
    private Object objetoDeClasse;

    public ManipuladorObjeto(Object objetoDeClasse) {
        this.objetoDeClasse = objetoDeClasse;
    }


    public ManipuladorMetodo getMetodo(String nomeMetodo, Map<String, Object> queryParams) {

        // -> classe/metodo?param=abcd&param=1234
        //->  produto/lista?nome=caneta&valor=1234

        Stream<Method> declaredMethods = Stream.of(objetoDeClasse.getClass().getDeclaredMethods());
        Method metodoSelecionado = declaredMethods.filter(metodo ->
                        metodo.getName().equals(nomeMetodo)
                                && metodo.getParameterCount() == queryParams.values().size()
                                &&
                                Stream.of(metodo.getParameters()).allMatch(param -> queryParams.keySet().contains(param.getName())
                                        && queryParams.get(param.getName()).getClass().equals(param.getType())))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Metodo não encontrado!"));

        return new ManipuladorMetodo(objetoDeClasse, metodoSelecionado, queryParams);

    }

    public ManipuladorMetodo getMetodo(String nomeMetodo) {
        try {
            Method declaredMethod = objetoDeClasse.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(declaredMethod, objetoDeClasse.getClass());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
