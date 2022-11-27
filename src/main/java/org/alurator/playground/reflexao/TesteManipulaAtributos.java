package org.alurator.playground.reflexao;

import org.estoque.api.modelo.Produto;

import java.util.Arrays;

public class TesteManipulaAtributos {

    public static void main(String[] args) {
        Object produto = new Produto("Produto 1", 20.0, "Marca 1");
        StringBuilder stb = new StringBuilder();

        Class<?> aClass = produto.getClass();

        Arrays.stream(aClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                stb.append("<"+f.getName()+">"+f.get(produto)+"</"+f.getName()+">");
                System.out.println(f.getName() +":"+ f.get(produto));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });

    }

}
