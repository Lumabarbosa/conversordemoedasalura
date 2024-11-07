package modelos;

import java.util.Scanner;

public class MenuInteracao {
    private final ConsultaApi consultaApi;
    private HistoricoConversoes historicoConversoes = new HistoricoConversoes();

    public MenuInteracao(HistoricoConversoes historicoConversoes) {
        this.historicoConversoes = historicoConversoes;
        this.consultaApi = new ConsultaApi();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        String moedaEntrada;
        String moedaSaida;
        double valorOriginal;
        ConsultaApi consultaApiCliente = new ConsultaApi();

        while (true) {
            // Menu de entrada do usuário
            System.out.println("**************************************************************");
            System.out.println("Seja bem vindo/a ao Conversor de Moedas!\n");
            System.out.println("Escolha um número dentre as opções abaixo:");
            System.out.println("1) Dólar ==> Peso argentino");
            System.out.println("2) Peso argentino ==> Dólar");
            System.out.println("3) Dólar ==> Real brasileiro");
            System.out.println("4) Real brasileiro ==> Dólar");
            System.out.println("5) Dólar ==> Peso colombiano");
            System.out.println("6) Peso colombiano ==> Dólar");
            System.out.println("7) Escolha outras moedas");
            System.out.println("8) Sair");
            System.out.println("**************************************************************\n");

            System.out.println("Digite a sua escolha: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    moedaEntrada = "USD";
                    moedaSaida = "ARS";
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 2:
                    moedaEntrada = "ARS";
                    moedaSaida = "USD";
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 3:
                    moedaEntrada = "USD";
                    moedaSaida = "BRL";
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 4:
                    moedaEntrada = "BRL";
                    moedaSaida = "USD";
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 5:
                    moedaEntrada = "USD";
                    moedaSaida = "COP";
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 6:
                    moedaEntrada = "COP";
                    moedaSaida = "USD";
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 7:
                    System.out.println("Digite o código da moeda de origem (ex: USD)");
                    moedaEntrada = scanner.next().toUpperCase();
                    System.out.println("Digite o código da moeda de destino (ex: EUR): ");
                    moedaSaida = scanner.next().toUpperCase();
                    valorOriginal = obterValor(scanner);
                    realizarConversao(consultaApiCliente, moedaEntrada, moedaSaida, valorOriginal);
                    break;

                case 8:
                    System.out.println("Finalizando o programa!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    private static double obterValor(Scanner scanner) {
        System.out.print("Digite o valor a ser convertido: ");
        return scanner.nextDouble();
    }

    private void realizarConversao(ConsultaApi consultaApi, String moedaEntrada, String moedaSaida, double valorOriginal) {
        try {
            // Obtenha a taxa de câmbio da API e calcula o valor convertido
            consultaApi = new ConsultaApi();
            double taxaCambio = consultaApi.obterTaxaDeCambio(moedaEntrada, moedaSaida);
            double valorConvertido = valorOriginal * taxaCambio;

            // Cria um objeto de conversão de moeda e exiba a saída formatada
            ConversaoMoeda conversao = new ConversaoMoeda(moedaEntrada, moedaSaida, valorOriginal, valorConvertido, taxaCambio);
            System.out.println(conversao);

            // Salva as conversões
            historicoConversoes.salvarConversao(conversao);

        } catch (IllegalArgumentException e) {
            System.out.println("Moeda não encontrada: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Taxa de câmbio não encontrada: " + e.getMessage());
        } finally {
            System.out.println("O programa encerrou corretamente");
        }
    }
}

