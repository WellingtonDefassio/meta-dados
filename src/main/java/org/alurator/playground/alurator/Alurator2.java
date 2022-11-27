package org.alurator.playground.alurator;

import org.alurator.playground.alurator.ioc.ContainerIOC;
import org.alurator.playground.alurator.protocolo.Request;
import org.alurator.playground.alurator.reflexao.ManipuladorObjeto;
import org.alurator.playground.alurator.reflexao.Reflexao;
import org.alurator.playground.conversores.ConversorXML;
import org.estoque.api.dao.ProdutoDao;
import org.estoque.api.dao.ProdutoDaoMock;

import java.util.Map;

public class Alurator2 {

    private String pacote;
    private ContainerIOC containerIOC;

    public Alurator2(String pacote) {
        this.pacote = pacote;
        this.containerIOC = new ContainerIOC();
    }

    public Object executa(String url) {
        Request request = new Request(url);
        String nomeControle = request.getNomeControle();
        String nomeMetodo = request.getNomeMetodo();
        Map<String, Object> queryParams = request.getQueryParams();

        try {

            Class<?> classeControle = new Reflexao().getClasse(pacote + "." + nomeControle);
            Object instancia = containerIOC.getInstancia(classeControle);

            Object retorno = new ManipuladorObjeto(instancia)
                    .getMetodo(nomeMetodo, queryParams)
                    .comTratamentoDeExcecao((metodo, ex) -> {
                        System.out.println("erro no metodo " + metodo.getName() + " da classe");
                        throw  new RuntimeException("Erro no método!");
                    })
                    .invoca();

           retorno = new ConversorXML().converte(retorno);


            return retorno;
        } catch (Exception e) {
			System.out.println(e);
        }

        return null;
    }

    public <T, K extends T> void registra(Class<T> tipoFronte, Class<K> tipoDestino) {
        containerIOC.registra(tipoFronte, tipoDestino);
    }
}
