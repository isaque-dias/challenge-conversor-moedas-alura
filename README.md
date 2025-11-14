# 💱 Conversor de Moedas - Challenge Alura

Projeto desenvolvido como desafio da Alura para criar um conversor de moedas em Java que utiliza uma API para obter taxas de câmbio em tempo real.

## 📋 Descrição

Este projeto é um conversor de moedas interativo que permite converter valores entre diferentes moedas utilizando taxas de câmbio obtidas dinamicamente da API ExchangeRate-API. O programa oferece um menu textual com múltiplas opções de conversão.

## ✨ Funcionalidades

- ✅ Menu interativo com 12 opções de conversão
- ✅ Suporte para 6 moedas: USD, BRL, ARS, BOB, CLP, COP
- ✅ Taxas de câmbio em tempo real via API
- ✅ Interface amigável no console
- ✅ Tratamento de erros robusto
- ✅ Validação de entrada do usuário

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Maven** - Gerenciamento de dependências
- **Gson 2.10.1** - Manipulação de JSON
- **HttpClient** (Java 11+) - Requisições HTTP
- **ExchangeRate-API** - API de taxas de câmbio

## 📦 Pré-requisitos

- Java JDK 17 ou superior
- Maven 3.6+ (ou IDE com suporte a Maven)
- Chave de API do ExchangeRate-API (gratuita)

## 🚀 Como Configurar

### 1. Obter Chave da API

1. Acesse [ExchangeRate-API](https://www.exchangerate-api.com/)
2. Crie uma conta gratuita
3. Obtenha sua chave de API

### 2. Configurar a Chave da API

Você pode configurar a chave da API de duas formas:

**Opção 1: Variável de Ambiente (Recomendado)**

No Linux/Mac:
```bash
export EXCHANGE_RATE_API_KEY="sua-chave-aqui"
```

No Windows (PowerShell):
```powershell
$env:EXCHANGE_RATE_API_KEY="sua-chave-aqui"
```

No Windows (CMD):
```cmd
set EXCHANGE_RATE_API_KEY=sua-chave-aqui
```

**Opção 2: Editar o Código**

Abra o arquivo `src/main/java/com/alura/conversor/service/ExchangeRateService.java` e substitua:

```java
private static final String API_KEY = "YOUR_API_KEY_HERE";
```

pela sua chave da API:

```java
private static final String API_KEY = "sua-chave-aqui";
```

### 3. Compilar o Projeto

Se estiver usando Maven via linha de comando:

```bash
mvn clean compile
```

Se estiver usando uma IDE (IntelliJ IDEA, Eclipse, etc.):
- A IDE geralmente compila automaticamente
- Certifique-se de que o Maven baixou as dependências

### 4. Executar o Projeto

**Via linha de comando:**

```bash
mvn exec:java -Dexec.mainClass="com.alura.conversor.ConversorDeMoedas"
```

**Ou compile e execute manualmente:**

```bash
mvn clean package
java -cp target/classes:target/dependency/* com.alura.conversor.ConversorDeMoedas
```

**Via IDE:**
- Execute a classe `ConversorDeMoedas.java`

## 📖 Como Usar

1. Execute o programa
2. Escolha uma opção do menu (1-12)
3. Digite o valor a ser convertido
4. O programa exibirá o valor convertido e a taxa de câmbio atual
5. Pressione ENTER para continuar ou escolha a opção 0 para sair

## 💱 Moedas Suportadas

- **USD** - Dólar Americano
- **BRL** - Real Brasileiro
- **ARS** - Peso Argentino
- **BOB** - Boliviano Boliviano
- **CLP** - Peso Chileno
- **COP** - Peso Colombiano

## 📁 Estrutura do Projeto

```
challenge-conversor-moedas-alura/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── alura/
│                   └── conversor/
│                       ├── ConversorDeMoedas.java      # Classe principal
│                       ├── model/
│                       │   └── ExchangeRateResponse.java # Modelo de resposta da API
│                       ├── service/
│                       │   └── ExchangeRateService.java # Serviço de requisições HTTP
│                       └── util/
│                           └── CurrencyCode.java        # Enum de códigos de moedas
├── pom.xml                                              # Configuração Maven
└── README.md                                            # Este arquivo
```

## 🔧 Adicionando Gson no IntelliJ IDEA (Alternativa)

Se preferir adicionar manualmente sem Maven:

1. Clique com o botão direito na pasta do projeto
2. Selecione "Abrir Configurações do Módulo"
3. Vá para a aba "Dependências"
4. Clique no "+" e escolha "Biblioteca"
5. Procure por "gson" e selecione a versão 2.10.1 ou superior

## 📝 Exemplo de Uso

```
╔════════════════════════════════════════╗
║   💱 CONVERSOR DE MOEDAS 💱            ║
╚════════════════════════════════════════╝

╔════════════════════════════════════════╗
║        MENU DE CONVERSÃO               ║
╠════════════════════════════════════════╣
║  1. USD → BRL (Dólar → Real)          ║
║  2. BRL → USD (Real → Dólar)          ║
...
╚════════════════════════════════════════╝

Escolha uma opção: 1

══════════════════════════════════════════
Conversão: Dólar Americano → Real Brasileiro
══════════════════════════════════════════
Digite o valor em Dólar Americano (USD): 100

⏳ Consultando taxa de conversão...

══════════════════════════════════════════
✅ CONVERSÃO REALIZADA COM SUCESSO!
══════════════════════════════════════════
Valor original: USD 100,00
Taxa de conversão: 1 USD = 5,20 BRL
Valor convertido: BRL 520,00
══════════════════════════════════════════
```

## 🐛 Tratamento de Erros

O programa trata os seguintes erros:
- Valores inválidos (não numéricos)
- Valores negativos
- Erros de conexão com a API
- Requisições interrompidas
- Erros da API

## 📚 Recursos de Aprendizado

Este projeto demonstra:
- Uso de `HttpClient` para requisições HTTP
- Uso de `HttpRequest` e `HttpResponse`
- Parse de JSON com Gson
- Programação orientada a objetos
- Tratamento de exceções
- Interface de console interativa
- Uso de Maven para gerenciamento de dependências

## 📄 Licença

Este projeto é parte de um desafio educacional da Alura.

## 👨‍💻 Autor

Desenvolvido como parte do Challenge Conversor de Moedas da Alura.
