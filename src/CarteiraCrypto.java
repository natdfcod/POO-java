import java.util.Scanner;
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
    String nomeCripto;
    protected double saldoCrypto;

    /**
     * Construtor da CarteiraCrypto.
     * * @param titular O nome do dono da carteira.
     * @param saldoInicial O saldo inicial de Crypto na carteira.
     */
    public CarteiraCrypto(String titular, String nomeCripto, double saldoInicial) {
        this.titular = titular;
        this.nomeCripto = nomeCripto.toUpperCase();
        this.saldoCrypto = saldoInicial;
    }

    /**
     * Realiza um depósito na carteira.
     * * @param valor A quantidade de crypto a ser depositada. Deve ser maior que zero.
     */
    public void depositar(double valor) {
        if (valor > 0) {
            saldoCrypto += valor;
        }
    }

    /**
     * Realiza um saque da carteira, aplicando uma taxa fixa de 1%.
     * * @param valor A quantidade de Bitcoin que se deseja sacar (sem contar a taxa).
     * @return true se o saldo for suficiente para cobrir o valor mais a taxa e o saque for aprovado, false caso contrário.
     */
    public boolean sacar(double valor) {
        if  (saldoCrypto >= valor+0.01) {
            saldoCrypto -= valor+0.01;
            System.out.println("Saque aprovado!! Taxa de 1% por saque aplicada");
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
        System.out.printf("Titular: %s\nSaldo: %.2f %S\n", this.titular, this.saldoCrypto, this.nomeCripto);
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
    public void comprarCypto(double valorReais, MetodoPagamento metodo) {
        Scanner sc = new Scanner(System.in);
        double qntCriptoComprada, precoAtual;
        // 1. O cliente paga em Reais (O contrato da interface garante que isso funciona!)
        metodo.processarPagamento(valorReais);
        //Se for bitcoin, ele pega o valor real de mercado com a api
        if (nomeCripto.equals("BITCOIN")){
            // 2. O sistema vai na internet e descobre quanto vale 1 Bitcoin hoje
            CotacaoBTC_API api = new CotacaoBTC_API();
            precoAtual = api.obterPrecoBitcoinEmReais();
        } else {
            //se nn for bit coin ele pede pra contar qnto está a contação
            System.out.println("Digite a cotação atual da crypto desejada: ");
            precoAtual = sc.nextDouble();
        }
        // 3. Faz a matemática: converte os Reais para fração da Crypto
        qntCriptoComprada = valorReais / precoAtual;

        // 4. Deposita a Crypto fictícia no saldo trancado (usando o método que você já criou)
        this.depositar(qntCriptoComprada);

        System.out.printf(">>> Cotação do momento: R$ %.2f | Você comprou: %.8f %s\n\n", precoAtual, qntCriptoComprada, this.nomeCripto);
    }
}