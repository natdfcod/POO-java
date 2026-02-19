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
}