package org.alurator.playground.alurator.reflexao;

public class ManipuladorClasse {
    private Class<?> classeContrutor;

    public ManipuladorClasse(Class<?> classeContrutor) {
        this.classeContrutor = classeContrutor;
    }

    public ManipuladorConstrutor getContrutorPadrao() {
        try {
            return new ManipuladorConstrutor(classeContrutor.getDeclaredConstructor());
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

    }
}
