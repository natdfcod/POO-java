# 🪙 Carteira Digital de Criptomoedas (Crypto Wallet)

Um projeto prático de Programação Orientada a Objetos (POO) desenvolvido em Java, focado em simular as operações básicas de uma carteira de Bitcoin. O sistema aplica regras de negócio reais, como cobrança de taxas de operação, diferentes categorias de clientes, processamento de pagamentos em Reais e consumo de dados do mercado financeiro em tempo real.

Este projeto foi construído como parte do aprendizado prático da grade de Sistemas de Informação na FIAP, servindo como base para entender a arquitetura de sistemas financeiros e integração com serviços externos.

## 🚀 Funcionalidades

O sistema simula transações de Bitcoin (`saldoBitcoin`) com as seguintes capacidades:

* **Depósito:** Adição de fundos à carteira, com validação de valores positivos.
* **Saque:** Retirada de fundos com aplicação de uma taxa fixa de `0.01 BTC` por operação.
* **Transferência:** Envio de saldo entre diferentes contas, utilizando a lógica de saque da conta origem e depósito na conta destino.
* **Contas VIP:** Implementação de uma `CarteiraVip` que isenta o titular de taxas de saque.
* **Processamento de Pagamentos:** Simulação de depósito na corretora pagando em Reais (BRL), suportando diferentes regras de negócio (PIX sem taxas e Cartão de Crédito com taxa de 5%).
* **Cotação em Tempo Real (API):** Conversão automática do dinheiro depositado em Reais para frações de Bitcoin, consumindo o preço atualizado diretamente da API pública da corretora Binance.
* **Extrato:** Exibição formatada no console do titular e do saldo atual.

## 🛠️ Tecnologias e Conceitos Aplicados

* **Linguagem:** Java
* **Integração Web:** Uso das bibliotecas nativas `java.net.http.HttpClient` e `HttpRequest` para consumo de API REST (HTTP GET).
* **Paradigma:** Orientação a Objetos (POO)
* **Encapsulamento:** Proteção do saldo através de modificadores de acesso (`protected` e `private`).
* **Herança:** A classe `CarteiraVip` herda características e comportamentos da classe base `CarteiraCrypto`.
* **Polimorfismo:** Sobrescrita (`@Override`) do método `sacar()` na classe VIP para alterar a regra de negócio e remover a taxa da operação.
* **Interfaces:** Criação de contratos (`MetodoPagamento`) para garantir que diferentes formas de pagamento (`Pix`, `CartaoCredito`) implementem obrigatoriamente as mesmas assinaturas de processamento.


* **Documentação:** Javadoc

## ⚙️ Como executar o projeto

Para rodar o código na sua máquina localmente, você precisará ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) (versão 11 ou superior recomendada pelo uso do HttpClient) instalado.

1. Clone este repositório:
```bash
git clone https://github.com/natdfcod/POO-java.git

```


2. Navegue até o diretório do projeto:
```bash
cd POO-java/src

```


3. Compile os arquivos Java:
```bash
javac *.java

```


4. Execute a classe Principal (`Main`):
```bash
java Main

```



## 📖 Como visualizar a documentação (Javadoc)

Este projeto possui o código todo documentado utilizando o padrão Javadoc. Para ler a documentação e entender como as classes e métodos interagem, você tem algumas opções:

### Opção 1: Visualizar direto (Mais recomendada)

Se você baixou ou clonou este repositório completo:

1. Navegue até a pasta `docs/` no seu explorador de arquivos.
2. Dê um duplo clique no arquivo `index.html`.
3. A documentação será aberta no seu navegador padrão com toda a estrutura do projeto!

---

*Desenvolvido por Nicolas.*
