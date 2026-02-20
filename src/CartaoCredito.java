/**
 * Representa o método de pagamento via Cartão de Crédito.
 * <p>
 * Operações realizadas via cartão de crédito possuem o acréscimo de uma taxa percentual
 * (5%) sobre o valor original da transação cobrada pela operadora.
 * </p>
 *
 * @author Nicolas
 */
public class CartaoCredito implements MetodoPagamento{
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento via Cartão aprovado. Valor: R$ %.2f | Taxa: R$ %.2f | Total a pagar: R$ %.2f\n",valor, valor*0.05, valor*1.05);


    }
}
