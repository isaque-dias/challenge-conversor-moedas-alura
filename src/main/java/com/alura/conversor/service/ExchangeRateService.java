package com.alura.conversor.service;

import com.alura.conversor.model.ExchangeRateResponse;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class ExchangeRateService {

    private static final String API_BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private static final String API_KEY = System.getenv("EXCHANGE_RATE_API_KEY") != null 
            ? System.getenv("EXCHANGE_RATE_API_KEY") 
            : "3996e64c9a4c1839f4e62364";

    private final HttpClient httpClient;
    private final Gson gson;

    public ExchangeRateService() {
        this.httpClient = HttpClient.newBuilder()
                .connectTimeout(Duration.ofSeconds(10))
                .build();
        this.gson = new Gson();
    }


    public ExchangeRateResponse getExchangeRate(String baseCode, String targetCode) 
            throws IOException, InterruptedException {
        String url = API_BASE_URL + API_KEY + "/pair/" + baseCode + "/" + targetCode;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .timeout(Duration.ofSeconds(10))
                .build();

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Erro na requisição: Status " + response.statusCode());
        }

        JsonElement element = JsonParser.parseString(response.body());
        JsonObject jsonObject = element.getAsJsonObject();

        // Verifica se a requisição foi bem sucedida
        String result = jsonObject.get("result").getAsString();
        if (!"success".equals(result)) {
            throw new IOException("Erro na API: " + jsonObject.get("error-type").getAsString());
        }

        return gson.fromJson(jsonObject, ExchangeRateResponse.class);
    }

    public double convertCurrency(String baseCode, String targetCode, double amount) 
            throws IOException, InterruptedException {
        ExchangeRateResponse response = getExchangeRate(baseCode, targetCode);
        return amount * response.getConversion_rate();
    }
}

