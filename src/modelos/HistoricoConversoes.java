package modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HistoricoConversoes {
    private static final String NOME_ARQUIVO = "consultas.txt";

    // Método para salvar uma conversão no arquivo de histórico
    public void salvarConversao(ConversaoMoeda conversao) {
        // Formatador de data e hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String dataHora = LocalDateTime.now().format(formatter);

        // Criação do conteúdo que será salvo no arquivo
        String conteudo = String.format(
                "Data e Hora da Conversão: %s\n" +
                        "Conversão de %.2f %s para %s:\n" +
                        "Valor Original: %.2f %s\n" +
                        "Valor Convertido: %.2f %s\n" +
                        "Taxa de Câmbio Utilizada: 1 %s = %.4f %s\n" +
                        "--------------------------------------------\n",
                dataHora,
                conversao.getValorOriginal(), conversao.getmoedaEntrada(), conversao.getmoedaSaida(),
                conversao.getValorOriginal(), conversao.getmoedaEntrada(),
                conversao.getValorConvertido(), conversao.getmoedaSaida(),
                conversao.getmoedaEntrada(), conversao.getTaxaCambio(), conversao.getmoedaSaida()
        );

        // Escreve o conteúdo no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            writer.write(conteudo);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o histórico de conversão: " + e.getMessage());
        }
    }
}
