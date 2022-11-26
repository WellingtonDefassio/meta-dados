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

    public ManipuladorMetodo getMethodoPadraoo(String nomeMethod) {
        try {
                return new ManipuladorMetodo(classeContrutor.getDeclaredMethod(nomeMethod), classeContrutor);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public ManipuladorObjeto criaInstancia() {
      return new ManipuladorObjeto(getContrutorPadrao().invoca());
    }
}
