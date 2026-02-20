# 🪙 Carteira Digital de Criptomoedas (Crypto Wallet)

Um projeto prático de Programação Orientada a Objetos (POO) desenvolvido em Java, focado em simular as operações básicas de uma carteira de Bitcoin. O sistema aplica regras de negócio reais, como cobrança de taxas de operação e diferentes categorias de clientes, aliando conceitos sólidos de engenharia de software com o ecossistema de criptoativos.

Este projeto foi construído como parte do aprendizado prático da grade de Sistemas de Informação na FIAP, servindo como base para entender a arquitetura de sistemas financeiros simples.

## 🚀 Funcionalidades

O sistema simula transações de Bitcoin (`saldoBitcoin`) com as seguintes capacidades:
- **Depósito:** Adição de fundos à carteira, com validação de valores positivos.
- **Saque:** Retirada de fundos com aplicação de uma taxa fixa de `0.01 BTC` por operação.
- **Transferência:** Envio de saldo entre diferentes contas, utilizando a lógica de saque da conta origem e depósito na conta destino.
- **Contas VIP:** Implementação de uma `CarteiraVip` que isenta o titular de taxas de saque.
- **Extrato:** Exibição formatada no console do titular e do saldo atual.

## 🛠️ Tecnologias e Conceitos Aplicados

- **Linguagem:** Java
- **Paradigma:** Orientação a Objetos (POO)
  - **Encapsulamento:** Proteção do saldo através de modificadores de acesso (`protected`).
  - **Herança:** A classe `CarteiraVip` herda características e comportamentos da classe base `CarteiraCrypto`.
  - **Polimorfismo:** Sobrescrita (`@Override`) do método `sacar()` na classe VIP para alterar a regra de negócio e remover a taxa da operação.
- **Documentação:** Javadoc

## ⚙️ Como executar o projeto

Para rodar o código na sua máquina localmente, você precisará ter o [Java JDK](https://www.oracle.com/java/technologies/downloads/) instalado.

1. Clone este repositório:
   ```bash
     git clone [https://github.com/natdfcod/POO-java.git](https://github.com/natdfcod/POO-java.git)

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



*Desenvolvido por Nicolas.*
