package org.alurator.playground.reflexao;

import org.alurator.playground.alurator.Alurator;
import org.alurator.playground.controle.Controle;
import org.alurator.playground.controle.SubControle;

import java.lang.reflect.Constructor;

public class TesteInstanciaCorretamente {

    public static void main(String[] args) throws Exception {

        Class<SubControle> subControleClass1 = SubControle.class;

        Class<?> controleClass = Class.forName("org.alurator.playground.controle.Controle");
        Class<?> subControleClass = Class.forName("org.alurator.playground.controle.SubControle");


        Constructor<SubControle> declaredConstructor = subControleClass1.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        System.out.println(declaredConstructor);
        SubControle subControle = declaredConstructor.newInstance();

        Constructor<SubControle> constructorSub = subControleClass1.getConstructor();
        System.out.println(constructorSub);
        constructorSub.newInstance();

        Constructor<SubControle> constructor = subControleClass1.getDeclaredConstructor(String.class);
        System.out.println(constructor);
    }



}
