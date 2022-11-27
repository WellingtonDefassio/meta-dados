package org.alurator.playground.conversores;

import org.alurator.playground.alurator.anotacao.NomeTagXML;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;

public class ConversorXML {


    public String converte(Object objeto) {
        try {
            Class<?> classeObjeto = objeto.getClass();
            StringBuilder xmlBuilder = new StringBuilder();

            if (objeto instanceof Collection) {
                Collection<?> colecao = (Collection<?>) objeto;
                xmlBuilder.append("<lista>\n");

                colecao.stream().forEach(item -> {
                    String xml = converte(item);
                    xmlBuilder.append(xml);
                });

                xmlBuilder.append("</lista>");
            } else {

                String nomeClasse = verificaAnnotation(classeObjeto);
                xmlBuilder.append(" <" + nomeClasse + ">\n");
                Arrays.stream(classeObjeto.getDeclaredFields()).forEach(field -> {
                    field.setAccessible(true);
                    xmlBuilder.append(verificaAnnotation(field, objeto));
                });
                xmlBuilder.append(" </" + nomeClasse + ">\n");

            }
            return xmlBuilder.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String verificaAnnotation(Field field, Object objeto) {
        try {
            if (field.isAnnotationPresent(NomeTagXML.class)) {

                return "   <" + field.getAnnotation(NomeTagXML.class).valor() + ">" + field.get(objeto) + "</" + field.getAnnotation(NomeTagXML.class).valor() + ">\n";
            } else {
                return "   <" + field.getName() + ">" + field.get(objeto) + "</" + field.getName() + ">\n";
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }


    private String verificaAnnotation(Class<?> classeObjeto) {
        if (classeObjeto.isAnnotationPresent(NomeTagXML.class)) {
            return classeObjeto.getAnnotation(NomeTagXML.class).valor();
        } else {
            return classeObjeto.getSimpleName().toLowerCase();
        }
    }
}
