package org.alurator.playground.alurator.reflexao;

public class Reflexao {

    public ManipuladorClasse reflete(String s) {

        return new ManipuladorClasse(getClasse(s));

    }

    public Class<?> getClasse(String s) {
        try {
            Class<?> classe = Class.forName(s);
            return classe;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
