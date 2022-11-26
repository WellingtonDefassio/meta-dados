package org.alurator.playground.reflexao;

import org.alurator.playground.controle.SubControle;

import java.lang.reflect.InvocationTargetException;

public class TesteInstanciaCorretamente2 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        Class<SubControle> subControleClass1 = SubControle.class;

        Class<?> controleClass = Class.forName("org.alurator.playground.controle.Controle2");
        Class<?> subControleClass = Class.forName("org.alurator.playground.controle.SubControle");

        try {
            controleClass.getDeclaredConstructor().newInstance();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
            System.out.println(e.getTargetException());
        }


    }


}
