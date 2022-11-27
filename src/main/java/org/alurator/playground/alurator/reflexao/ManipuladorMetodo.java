package org.alurator.playground.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class ManipuladorMetodo {


    BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao;
    private Object objetoDeClasse;
    private Method metodoSelecionado;
    private Map<String, Object> queryParams;
    private Class<?> classeContrutor;

    public ManipuladorMetodo(Object objetoDeClasse, Method metodoSelecionado, Map<String, Object> queryParams) {
        this.objetoDeClasse = objetoDeClasse;
        this.metodoSelecionado = metodoSelecionado;
        this.queryParams = queryParams;
    }

    public ManipuladorMetodo(Method declaredMethod, Class<?> classeContrutor) {
        this.classeContrutor = classeContrutor;
        this.metodoSelecionado = declaredMethod;

    }

    public ManipuladorMetodo comTratamentoDeExcecao(BiFunction<Method, InvocationTargetException, Object> tratamentoExcecao) {
        this.tratamentoExcecao = tratamentoExcecao;
        return this;
    }

    public Object invoca(Object invoca) {
        try {
            return metodoSelecionado.invoke(invoca);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

//    public Object invoca(Object invoca) {
//        try {
//            return metodoSelecionado.invoke(invoca);
//        } catch (IllegalAccessException e) {
//            throw new RuntimeException(e);
//        } catch (InvocationTargetException e) {
//            throw new RuntimeException(e);
//        }
//    }

    public Object invoca() {

        List<Object> parametros = new ArrayList<>();
        Stream.of(metodoSelecionado.getParameters())
                .forEach(p -> parametros.add(queryParams.get(p.getName())));

        try {
            return metodoSelecionado.invoke(objetoDeClasse, parametros.toArray());

        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {

            if (tratamentoExcecao != null) {
                return tratamentoExcecao.apply(metodoSelecionado, e);
            }
            e.printStackTrace();
            throw new RuntimeException("Erro no método!", e.getTargetException());
        }
    }
}
