package modelos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConversaoMoeda {
    private final String moedaEntrada;
    private final String moedaSaida;
    private final double valorOriginal;
    private final double valorConvertido;
    private final double taxaCambio;
    private final String dataHoraConversao;

    public ConversaoMoeda(String moedaEntrada, String moedaSaida, double valorOriginal, double valorConvertido, double taxaCambio) {
        this.moedaEntrada = moedaEntrada;
        this.moedaSaida = moedaSaida;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.taxaCambio = taxaCambio;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        this.dataHoraConversao = LocalDateTime.now().format(dateTimeFormatter);
    }

    public String getmoedaEntrada() {
        return moedaEntrada;
    }

    public String getmoedaSaida() {
        return moedaSaida;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }

    public double getTaxaCambio() {
        return taxaCambio;
    }

    @Override
    public String toString() {
        return String.format(
                "----------------------------------------------------------------\n" +
                "Você solicitou a conversão de %.2f %s para %s:\n" +
                        "----------------------------------------------------------------\n" +
                        "Já tenho os resultados para você:\n" +
                        "- Valor Original: %.2f %s\n" +
                        "- Valor Convertido para %s: %.2f\n" +
                        "- Taxa de Câmbio Utilizada: 1 %s = %.4f %s\n" +
                        "- Data e hora do instante da conversão: %s\n" +
                "----------------------------------------------------------------\n",
                valorOriginal, moedaEntrada, moedaSaida,
                valorOriginal, moedaEntrada,
                moedaSaida, valorConvertido,
                moedaEntrada, taxaCambio, moedaSaida,
                dataHoraConversao
        );
    }
}
