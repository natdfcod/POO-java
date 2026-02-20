/**
 * Representa uma carteira de criptomoedas padrão.
 * <p>
 * Esta classe base gerencia o titular e o saldo em Bitcoin, fornecendo
 * as operações fundamentais como depósito, saque e transferência.
 * Em carteiras padrão, as operações de saque possuem uma taxa fixa.
 * </p>
 */
public class CarteiraCrypto {
    String titular;
    protected double saldoBitcoin;

    /**
     * Construtor da CarteiraCrypto.
     * * @param titular O nome do dono da carteira.
     * @param saldoInicial O saldo inicial de Bitcoins na carteira.
     */
    public CarteiraCrypto(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldoBitcoin = saldoInicial;
    }

    /**
     * Realiza um depósito na carteira.
     * * @param valor A quantidade de Bitcoin a ser depositada. Deve ser maior que zero.
     */
    public void depositar(double valor) {
        if (valor > 0) {
            saldoBitcoin += valor;
        }
    }

    /**
     * Realiza um saque da carteira, aplicando uma taxa fixa de 0.01 BTC.
     * * @param valor A quantidade de Bitcoin que se deseja sacar (sem contar a taxa).
     * @return true se o saldo for suficiente para cobrir o valor mais a taxa e o saque for aprovado, false caso contrário.
     */
    public boolean sacar(double valor) {
        if  (saldoBitcoin >= valor+0.01) {
            saldoBitcoin -= valor+0.01;
            System.out.println("Saque aprovado!! Taxa de 0.01 BTC por saque aplicada");
            return true;
        }
        System.out.println("Saldo insuficiente!");
        return false;
    }

    /**
     * Transfere Bitcoins desta carteira para uma carteira de destino.
     * <p>
     * A transferência utiliza o método de saque, portanto, a taxa de saque
     * da carteira de origem será aplicada caso ela não seja isenta.
     * </p>
     * * @param valor A quantidade de Bitcoin a ser transferida.
     * @param destino A {@link CarteiraCrypto} que receberá o valor transferido.
     */
    public void transferir(double valor, CarteiraCrypto destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
        }
    }

    /**
     * Exibe o extrato atual da carteira no console, mostrando titular e saldo.
     */
    public void exibirExtrato(){
        System.out.printf("Titular: %s\nSaldo: %.2f\n", this.titular, this.saldoBitcoin);
    }

    /**
     * Realiza a compra de frações de Bitcoin utilizando moeda fiduciária (Reais).
     * <p>
     * O método aciona o contrato de pagamento escolhido para cobrar o cliente,
     * consulta a cotação atualizada na API externa e converte o montante pago
     * para a quantia correspondente em BTC, creditando automaticamente no saldo da carteira.
     * </p>
     *
     * @param valorReais O montante em Reais (BRL) que o cliente deseja investir.
     * @param metodo     A instância do método de pagamento (Pix, CartaoCredito, etc.) que será utilizado.
     */
    public void comprarBitcoin(double valorReais, MetodoPagamento metodo) {
        // 1. O cliente paga em Reais (O contrato da interface garante que isso funciona!)
        metodo.processarPagamento(valorReais);

        // 2. O sistema vai na internet e descobre quanto vale 1 Bitcoin hoje
        CotacaoAPI api = new CotacaoAPI();
        double precoAtual = api.obterPrecoBitcoinEmReais();

        // 3. Faz a matemática: converte os Reais para fração de Bitcoin
        double btcComprado = valorReais / precoAtual;

        // 4. Deposita o Bitcoin fictício no saldo trancado (usando o método que você já criou)
        this.depositar(btcComprado);

        System.out.printf(">>> Cotação do momento: R$ %.2f | Você comprou: %.8f BTC\n\n", precoAtual, btcComprado);
    }
}