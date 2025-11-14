package com.alura.conversor.util;


public enum CurrencyCode {
    ARS("Peso Argentino"),
    BOB("Boliviano Boliviano"),
    BRL("Real Brasileiro"),
    CLP("Peso Chileno"),
    COP("Peso Colombiano"),
    USD("Dólar Americano");

    private final String description;

    CurrencyCode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getCode() {
        return this.name();
    }
}

