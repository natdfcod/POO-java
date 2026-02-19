public class CarteiraVip extends CarteiraCrypto{
    public CarteiraVip(String titular, double saldoBitcoin){
        super(titular, saldoBitcoin);

    }
    public boolean sacar(double valor) {
        if  (saldoBitcoin >= valor) {
            saldoBitcoin -= valor;
            System.out.println("Saque aprovado!!");
            return true;
        }
        System.out.println("Saldo insuficiente!");
        return false;
    }
}
