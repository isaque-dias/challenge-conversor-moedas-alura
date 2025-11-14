package com.alura.conversor;

import com.alura.conversor.service.ExchangeRateService;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class ConversorDeMoedas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ExchangeRateService exchangeRateService = new ExchangeRateService();
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║         CONVERSOR DE MOEDAS            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println();

        boolean continuar = true;

        while (continuar) {
            exibirMenu();
            int opcao = lerOpcao();

            if (opcao == 0) {
                continuar = false;
                System.out.println("\nObrigado por usar o Conversor de Moedas!");
            } else {
                processarOpcao(opcao);
            }

            if (continuar) {
                System.out.println("\n" + "═".repeat(50));
                System.out.println("Pressione ENTER para continuar...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    // Menu Principal
    private static void exibirMenu() {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        MENU DE CONVERSÃO               ║");
        System.out.println("╠════════════════════════════════════════╣");
        System.out.println("║  1. USD → BRL (Dólar → Real)          ║");
        System.out.println("║  2. BRL → USD (Real → Dólar)          ║");
        System.out.println("║  3. BRL → ARS (Real → Peso Argentino) ║");
        System.out.println("║  4. ARS → BRL (Peso Argentino → Real) ║");
        System.out.println("║  5. BRL → CLP (Real → Peso Chileno)   ║");
        System.out.println("║  6. CLP → BRL (Peso Chileno → Real)   ║");
        System.out.println("║  7. BRL → COP (Real → Peso Colombiano)║");
        System.out.println("║  8. COP → BRL (Peso Colombiano → Real)║");
        System.out.println("║  9. BRL → BOB (Real → Boliviano)      ║");
        System.out.println("║ 10. BOB → BRL (Boliviano → Real)      ║");
        System.out.println("║ 11. USD → ARS (Dólar → Peso Argentino)║");
        System.out.println("║ 12. ARS → USD (Peso Argentino → Dólar) ║");
        System.out.println("║  0. Sair                               ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.print("\nEscolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            int opcao = Integer.parseInt(scanner.nextLine().trim());
            return opcao;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    // Processa a opção escolhida pelo usuário
    private static void processarOpcao(int opcao) {
        String baseCode, targetCode, baseName, targetName;

        switch (opcao) {
            case 1:
                baseCode = "USD";
                targetCode = "BRL";
                baseName = "Dólar Americano";
                targetName = "Real Brasileiro";
                break;
            case 2:
                baseCode = "BRL";
                targetCode = "USD";
                baseName = "Real Brasileiro";
                targetName = "Dólar Americano";
                break;
            case 3:
                baseCode = "BRL";
                targetCode = "ARS";
                baseName = "Real Brasileiro";
                targetName = "Peso Argentino";
                break;
            case 4:
                baseCode = "ARS";
                targetCode = "BRL";
                baseName = "Peso Argentino";
                targetName = "Real Brasileiro";
                break;
            case 5:
                baseCode = "BRL";
                targetCode = "CLP";
                baseName = "Real Brasileiro";
                targetName = "Peso Chileno";
                break;
            case 6:
                baseCode = "CLP";
                targetCode = "BRL";
                baseName = "Peso Chileno";
                targetName = "Real Brasileiro";
                break;
            case 7:
                baseCode = "BRL";
                targetCode = "COP";
                baseName = "Real Brasileiro";
                targetName = "Peso Colombiano";
                break;
            case 8:
                baseCode = "COP";
                targetCode = "BRL";
                baseName = "Peso Colombiano";
                targetName = "Real Brasileiro";
                break;
            case 9:
                baseCode = "BRL";
                targetCode = "BOB";
                baseName = "Real Brasileiro";
                targetName = "Boliviano";
                break;
            case 10:
                baseCode = "BOB";
                targetCode = "BRL";
                baseName = "Boliviano";
                targetName = "Real Brasileiro";
                break;
            case 11:
                baseCode = "USD";
                targetCode = "ARS";
                baseName = "Dólar Americano";
                targetName = "Peso Argentino";
                break;
            case 12:
                baseCode = "ARS";
                targetCode = "USD";
                baseName = "Peso Argentino";
                targetName = "Dólar Americano";
                break;
            default:
                System.out.println("\nOpção inválida! Por favor, escolha uma opção entre 0 e 12.");
                return;
        }

        realizarConversao(baseCode, targetCode, baseName, targetName);
    }


     // Realiza a conversão de moedas
    private static void realizarConversao(String baseCode, String targetCode, 
                                         String baseName, String targetName) {
        System.out.println("\n" + "═".repeat(50));
        System.out.println("Conversão: " + baseName + " → " + targetName);
        System.out.println("═".repeat(50));

        System.out.print("Digite o valor em " + baseName + " (" + baseCode + "): ");
        
        try {
            double valor = Double.parseDouble(scanner.nextLine().trim().replace(",", "."));

            if (valor < 0) {
                System.out.println("\nErro: O valor não pode ser negativo!");
                return;
            }

            System.out.println("\nConsultando taxa de conversão...");

            double valorConvertido = exchangeRateService.convertCurrency(baseCode, targetCode, valor);
            double taxa = exchangeRateService.getExchangeRate(baseCode, targetCode).getConversion_rate();

            System.out.println("\n" + "═".repeat(50));
            System.out.println("CONVERSÃO REALIZADA COM SUCESSO!");
            System.out.println("═".repeat(50));
            System.out.println("Valor original: " + baseCode + " " + df.format(valor));
            System.out.println("Taxa de conversão: 1 " + baseCode + " = " + df.format(taxa) + " " + targetCode);
            System.out.println("Valor convertido: " + targetCode + " " + df.format(valorConvertido));
            System.out.println("═".repeat(50));

        } catch (NumberFormatException e) {
            System.out.println("\nErro: Valor inválido! Por favor, digite um número válido.");
        } catch (IOException e) {
            System.out.println("\nErro ao conectar com a API: " + e.getMessage());
            System.out.println("Verifique sua conexão com a internet e tente novamente.");
        } catch (InterruptedException e) {
            System.out.println("\nErro: Requisição interrompida. Tente novamente.");
        } catch (Exception e) {
            System.out.println("\nErro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

