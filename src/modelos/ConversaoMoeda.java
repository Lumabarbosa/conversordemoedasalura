package modelos;

public class ConversaoMoeda {
    private final String moedaOrigem;
    private final String moedaDestino;
    private final double valorOriginal;
    private final double valorConvertido;
    private final double taxaCambio;

    public ConversaoMoeda(String moedaOrigem, String moedaDestino, double valorOriginal, double valorConvertido, double taxaCambio) {
        this.moedaOrigem = moedaOrigem;
        this.moedaDestino = moedaDestino;
        this.valorOriginal = valorOriginal;
        this.valorConvertido = valorConvertido;
        this.taxaCambio = taxaCambio;
    }

    public String getMoedaOrigem() {
        return moedaOrigem;
    }

    public String getMoedaDestino() {
        return moedaDestino;
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
                "Conversão de %.2f %s para %s:\n" +
                        "Valor Original: %.2f %s\n" +
                        "Valor Convertido: %.2f %s\n" +
                        "Taxa de Câmbio Utilizada: 1 %s = %.4f %s",
                valorOriginal, moedaOrigem, moedaDestino,
                valorOriginal, moedaOrigem,
                valorConvertido, moedaDestino,
                moedaOrigem, taxaCambio, moedaDestino
        );
    }
}
