package principal;

import modelos.ApiClient;
import modelos.ExchangeRates;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner scanner = new Scanner(System.in);
        ApiClient apiCliente = new ApiClient();
        ExchangeRates exchangeRates = new ExchangeRates();

        String moedaEntrada = "";
        String moedaSaida = "";
        double valor;

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
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
                    break;

                case 2:
                    moedaEntrada = "ARS";
                    moedaSaida = "USD";
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
                    break;

                case 3:
                    moedaEntrada = "USD";
                    moedaSaida = "BRL";
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
                    break;

                case 4:
                    moedaEntrada = "BRL";
                    moedaSaida = "USD";
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
                    break;

                case 5:
                    moedaEntrada = "USD";
                    moedaSaida = "COP";
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
                    break;

                case 6:
                    moedaEntrada = "COP";
                    moedaSaida = "USD";
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
                    break;

                case 7:
                    System.out.println("Digite o código da moeda de origem (ex: USD)");
                    moedaEntrada = scanner.next().toUpperCase();
                    System.out.println("Digite o código da moeda de destino (ex: EUR): ");
                    moedaSaida = scanner.next().toUpperCase();
                    valor = obterValor(scanner);
                    realizarConversao(apiCliente, moedaEntrada, moedaSaida, valor);
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

    private static void realizarConversao(ApiClient apiCliente, String moedaEntrada, String moedaSaida, double valor) {
        try {
            double valorConvertido = apiCliente.converterMoeda(moedaEntrada, moedaSaida, valor);
//            Conversao conversao = new Conversao();
//            System.out.println(conversao.toString());
            ExchangeRates exchangeRates = new ExchangeRates();
//            System.out.println("Teste" + exchangeRates.toString());
            System.out.printf("Conversão de %.2f %s para %s: %.2f%n\n", valor, moedaEntrada, moedaSaida, valorConvertido);
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro ao conectar-se à API: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Moeda não encontrada: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("taxa de câmbio não encontrada: " + e.getMessage());
        }
    }
}
