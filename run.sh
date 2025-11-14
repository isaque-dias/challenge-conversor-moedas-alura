#!/bin/bash

# Script para executar o Conversor de Moedas
# Certifique-se de ter configurado a variável de ambiente EXCHANGE_RATE_API_KEY

echo "💱 Compilando o Conversor de Moedas..."
mvn clean compile

if [ $? -eq 0 ]; then
    echo "✅ Compilação concluída com sucesso!"
    echo ""
    echo "🚀 Executando o programa..."
    echo ""
    mvn exec:java -Dexec.mainClass="com.alura.conversor.ConversorDeMoedas"
else
    echo "❌ Erro na compilação. Verifique os erros acima."
    exit 1
fi

