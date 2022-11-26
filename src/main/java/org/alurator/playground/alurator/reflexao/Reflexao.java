package org.alurator.playground.alurator.reflexao;

public class Reflexao {

    public ManipuladorClasse reflete(String s)  {
        try {
            return new ManipuladorClasse(Class.forName(s));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
