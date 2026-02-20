/**
 * Representa o método de pagamento via PIX.
 * <p>
 * Pagamentos via PIX são processados e aprovados instantaneamente,
 * sem a cobrança de taxas adicionais para o usuário.
 * </p>
 *
 * @author Nicolas
 */
public class PagamentoPix implements MetodoPagamento{
    @Override
    public void processarPagamento(double valor) {
        System.out.printf("Pagamento de R$ %.2f via PIX aprovado instantaneamente!\n", valor);
    }
}
