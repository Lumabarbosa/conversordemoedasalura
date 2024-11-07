package modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ConsultaApi {
    // URL base da API, substitua pela sua chave de API real
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/eb17398d29f63e47191807a1/pair/";

    public double obterTaxaDeCambio(String moedaEntrada, String moedaSaida) {
        // Constrói a URL completa para buscar a taxa de câmbio
        String url = BASE_URL + moedaEntrada + "/" + moedaSaida;

        // Cria o cliente HTTP e a solicitação
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        try {
            // Envia a requisição e recebe a resposta como uma string JSON
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Converte a resposta JSON em um objeto JsonObject
            JsonObject jsonResponse = new Gson().fromJson(response.body(), JsonObject.class);

            // Verifica se o campo "conversion_rate" existe e extrai a taxa de câmbio
            if (jsonResponse.has("conversion_rate")) {
                return jsonResponse.get("conversion_rate").getAsDouble();
            } else {
                throw new IOException("Erro: Taxa de câmbio não encontrada na resposta da API.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return 0.0; // Retorna 0.0 em caso de erro
        }
    }
}
