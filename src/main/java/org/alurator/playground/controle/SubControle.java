package org.alurator.playground.controle;

public class SubControle extends Controle{
    private SubControle(){
        System.out.println("subcontrole -> sem parametros");
    }
    private SubControle(String s) {}


    public void metodoSubControle1() {
        System.out.println("Executando metodo publico e retorno void parametros vazio metodoSubControle1()");
    }

    private String metodoSubControle2() {
        System.out.println("Executando metodo metodoSubControle2() privado (retorno String) (parametros vazio)");

        return "retornando a STRING do metodo metodoSubControle2() privado (retorno String) (parametros vazio)";
    }


}
