/**
 * Classe principal para testar o sistema de carteiras de criptomoedas.
 * <p>
 * Simula a criação de instâncias de carteiras padrão e VIP, realiza
 * operações de transferência e saque, e exibe os extratos para 
 * verificar a aplicação correta das regras de negócio e taxas.
 * </p>
 */
public class Main {
    /**
     * Ponto de entrada do programa.
     * * @param args Argumentos de linha de comando (não utilizados neste projeto).
     */
    public static void main(String[] args) {
        CarteiraVip nicolas = new CarteiraVip("Nicolas", 5);
        CarteiraCrypto matheus = new CarteiraCrypto("Matheus", 1.5);

        nicolas.transferir(2, matheus);

        nicolas.sacar(0.5);
        matheus.sacar(0.5);

        nicolas.exibirExtrato();
        matheus.exibirExtrato();

        //testando metodos de pagamento
        MetodoPagamento meuPix = new Pix();
        MetodoPagamento meuCartao = new CartaoCredito();
        //comprando em R$
        System.out.println("----Comprando 10000 em BTC no pix----");
        nicolas.comprarBitcoin(10000.0, meuPix);

        nicolas.exibirExtrato();

        System.out.println("----Comprando 10000 em BTC no cartão----");
        nicolas.comprarBitcoin(10000.0, meuCartao);

        nicolas.exibirExtrato();
    }
}