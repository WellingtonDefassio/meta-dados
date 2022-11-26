package org.alurator.playground.alurator.reflexao;

import java.lang.reflect.Method;

public class ManipuladorObjeto {
    private Object objetoDeClasse;

    public ManipuladorObjeto(Object objetoDeClasse) {
        this.objetoDeClasse = objetoDeClasse;
    }


    public ManipuladorMetodo getMetodo(String nomeMetodo) {
        try {
            Method declaredMethod = objetoDeClasse.getClass().getDeclaredMethod(nomeMetodo);
            return new ManipuladorMetodo(declaredMethod, objetoDeClasse);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
