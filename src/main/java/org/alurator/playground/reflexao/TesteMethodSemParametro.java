package org.alurator.playground.reflexao;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class TesteMethodSemParametro {


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> subControleClass = Class.forName("org.alurator.playground.controle.SubControle");
        Constructor<?> declaredConstructor = subControleClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Object newInstance = declaredConstructor.newInstance();

        System.out.println("########## GET METHODS ################");
        Method[] classMethods = subControleClass.getMethods();
        Arrays.stream(classMethods).forEach(System.out::println);


        System.out.println("########## DECLARED METHODS ################");
        Method[] declaredMethods = subControleClass.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);


        Method methodPublic = subControleClass.getDeclaredMethod("metodoSubControle1");
        Method methodPrivate = subControleClass.getDeclaredMethod("metodoSubControle2");
        System.out.println("########## PUBLIC METHOD EXECUTION ##########");
        methodPublic.invoke(newInstance);
        System.out.println("########## PRIVATE METHOD EXECUTION ##########");
        methodPrivate.setAccessible(true);
        Object invoke = methodPrivate.invoke(newInstance);
        System.out.println(invoke);


    }

}
