public class CarteiraCrypto {
    String titular;
    protected double saldoBitcoin;

    public CarteiraCrypto(String titular, double saldoInicial) {
        this.titular = titular;
        this.saldoBitcoin = saldoInicial;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldoBitcoin += valor;
        }
    }

    public boolean sacar(double valor) {
        if  (saldoBitcoin >= valor+0.01) {
            saldoBitcoin -= valor+0.01;
            System.out.println("Saque aprovado!! Taxa de 0.01 BTC por saque aplicada");
            return true;
        }
        System.out.println("Saldo insuficiente!");
        return false;
    }

    public void transferir(double valor, CarteiraCrypto destino) {
        if (this.sacar(valor)) {
            destino.depositar(valor);
        }
    }

    public void exibirExtrato(){
        System.out.printf("Titular: %s\nSaldo: %.2f\n", this.titular, this.saldoBitcoin);
    }
}
