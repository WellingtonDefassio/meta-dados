package org.alurator.playground.alurator.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Stream;

public class ContainerIOC {
    private Map<Class<?>, Class<?>> mapaDeTipos = new HashMap<>();

    public Object getInstancia(Class<?> tipoFonte) {
        Class<?> tipoDestino = mapaDeTipos.get(tipoFonte);
        if (tipoDestino != null) {
            return getInstancia(tipoDestino);
        }
        Stream<Constructor<?>> constructors =
                Stream.of(tipoFonte.getDeclaredConstructors());

        Optional<Constructor<?>> construtorPadrao =
                constructors.filter(constructor -> constructor.getParameterCount() == 0).findFirst();

        try {
            if (construtorPadrao.isPresent()) {
                Object instancia = construtorPadrao.get().newInstance();
                return instancia;
            } else {
                Constructor<?> constructor = tipoFonte.getDeclaredConstructors()[0];
                List<Object> params = new ArrayList<>();
                for (Parameter param : constructor.getParameters()) {
                    Class<?> tipoParametro = param.getType();
                    params.add(getInstancia(tipoParametro));
                }
                return constructor.newInstance(params.toArray());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public <T,K extends T> void registra(Class<T> tipoFronte, Class<K> tipoDestino) {

        boolean compativel = verificaCompatibilidadeEz(tipoFronte, tipoDestino);
        if (!compativel)
            throw new ClassCastException("Não é possivel resolver " + tipoFronte.getName() + " para " + tipoDestino.getName());
        mapaDeTipos.put(tipoFronte, tipoDestino);
    }

    private boolean verificaCompatibilidadeEz(Class<?> tipoFronte, Class<?> tipoDestino) {
        return tipoFronte.isAssignableFrom(tipoDestino);
    }
    private boolean verificaCompatibilidade(Class<?> tipoFronte, Class<?> tipoDestino) {
        boolean compativel;
        if (tipoFronte.isInterface()) {
            compativel = Stream.of(tipoDestino.getInterfaces())
                    .anyMatch(interfaceImplementada -> interfaceImplementada.equals(tipoFronte));
        } else {
            compativel = tipoDestino.getSuperclass().equals(tipoFronte)
                    || tipoDestino.equals(tipoFronte);
        }
        return compativel;
    }
}
