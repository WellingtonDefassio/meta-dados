package org.alurator.playground.reflexao;

import org.alurator.playground.alurator.anotacao.NomeTagXML;
import org.estoque.api.modelo.Produto;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

public class TesteManipulaAnotacao {
    public static void main(String[] args) throws NoSuchFieldException {
        Produto produto = new Produto("Produto", 20.0, "Marca 1");
        Class<? extends Produto> produtoClass = produto.getClass();

        System.out.println(produtoClass.getDeclaredAnnotation(NomeTagXML.class).valor());
        Field[] declaredFields = produtoClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            field.setAccessible(true);
            if(field.isAnnotationPresent(NomeTagXML.class)) {
                System.out.println(field.getAnnotation(NomeTagXML.class).valor());
            }
        });


    }
}
