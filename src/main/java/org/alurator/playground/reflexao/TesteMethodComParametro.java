package org.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TesteMethodComParametro {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> subControleClass = Class.forName("org.alurator.playground.controle.Controle");
        Constructor<?> declaredConstructor = subControleClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance();

        Method metodoControle = subControleClass.getDeclaredMethod("metodoControle2",  String.class);
        Object invoke = metodoControle.invoke(newInstance, "Teste", 100);

        System.out.println(invoke);


    }

}
