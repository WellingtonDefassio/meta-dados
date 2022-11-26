package org.alurator.playground.reflexao;

import org.alurator.playground.controle.Controle;
import org.alurator.playground.controle.SubControle;

public class TesteInstanciaObjeto {

    public static void main(String[] args) throws Exception {

        Class<Controle> controleClass1 = Controle.class;
//        Class<? extends Controle> controleClass2 = new SubControle().getClass();
        Class<?> controleClass3 = Class.forName("org.alurator.playground.controle.Controle");

        Object objetoControle = controleClass3.getDeclaredConstructor().newInstance();

        System.out.println(objetoControle instanceof Controle);

    }

}
