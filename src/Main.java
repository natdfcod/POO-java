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
        CarteiraVip nicolasBTC = new CarteiraVip("Nicolas", "Bitcoin", 1.0);
        CarteiraCrypto matheusETHER = new CarteiraCrypto("Matheus", "Etherium", 1.5);

        nicolasBTC.transferir(2, matheusETHER);

        nicolasBTC.sacar(0.5);
        matheusETHER.sacar(0.5);

        nicolasBTC.exibirExtrato();
        matheusETHER.exibirExtrato();

        //testando metodos de pagamento
        MetodoPagamento meuPix = new PagamentoPix();
        MetodoPagamento meuCartao = new PagamentoCartao();
        //comprando BTC em R$
        System.out.println("----Comprando 10000 em BTC no pix----");
        nicolasBTC.comprarCypto(10000.0, meuPix);

        nicolasBTC.exibirExtrato();

        System.out.println("----Comprando 10000 em BTC no cartão----");
        nicolasBTC.comprarCypto(10000.0, meuCartao);

        //comprando ETHER em R$
        System.out.println("----Comprando 10000 em ETHER no pix----");
        matheusETHER.comprarCypto(10000.0, meuPix);

        matheusETHER.exibirExtrato();

        System.out.println("----Comprando 10000 em ETHER no cartão----");
        matheusETHER.comprarCypto(10000.0, meuCartao);

        nicolasBTC.exibirExtrato();
        matheusETHER.exibirExtrato();
    }
}