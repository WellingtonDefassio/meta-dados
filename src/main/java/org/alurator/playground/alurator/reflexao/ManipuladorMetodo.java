package org.alurator.playground.alurator.reflexao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ManipuladorMetodo {
    private Method declaredMethod;
    private Object objetoDeClasse;

    public ManipuladorMetodo(Method declaredMethod, Object objetoDeClasse) {
        this.declaredMethod = declaredMethod;
        this.objetoDeClasse = objetoDeClasse;
    }

    public Object invoca(Object invoca) {
        try {
          return declaredMethod.invoke(invoca);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Object invoca() {
        try {
            return declaredMethod.invoke(objetoDeClasse);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
