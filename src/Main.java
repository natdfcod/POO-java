public class Main {
    public static void main(String[] args) {
        CarteiraVip nicolas = new CarteiraVip("Nicolas", 5);
        CarteiraCrypto matheus = new CarteiraCrypto("Matheus", 1.5);

        nicolas.transferir(2, matheus);

        nicolas.sacar(0.5);
        matheus.sacar(0.5);

        nicolas.exibirExtrato();
        matheus.exibirExtrato();
    }
}
