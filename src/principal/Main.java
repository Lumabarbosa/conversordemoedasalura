package principal;

import modelos.HistoricoConversoes;
import modelos.MenuInteracao;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        HistoricoConversoes historicoConversoes = new HistoricoConversoes();

        MenuInteracao menuInteracao = new MenuInteracao(historicoConversoes);
        menuInteracao.exibirMenu();

    }
}
