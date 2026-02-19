/**
 * Representa uma carteira de criptomoedas VIP.
 * <p>
 * Esta classe herda de {@link CarteiraCrypto}, mas oferece benefícios 
 * exclusivos, como a isenção de taxas nas operações de saque.
 * </p>
 */
public class CarteiraVip extends CarteiraCrypto{

    /**
     * Construtor da CarteiraVip.
     * * @param titular O nome do dono da carteira.
     * @param saldoBitcoin O saldo inicial de Bitcoins na carteira.
     */
    public CarteiraVip(String titular, double saldoBitcoin){
        super(titular, saldoBitcoin);
    }

    /**
     * Realiza um saque da carteira VIP.
     * <p>
     * Sobrescreve o método da classe pai para remover a cobrança da taxa de 0.01 BTC.
     * </p>
     * * @param valor A quantidade exata de Bitcoin que se deseja sacar.
     * @return true se o saldo for suficiente e o saque for aprovado, false caso contrário.
     */
    @Override
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