/**
 * Interface que define o contrato obrigatório para os métodos de pagamento aceitos na corretora.
 * <p>
 * Qualquer classe que represente uma forma de pagamento (como Pix ou Cartão de Crédito)
 * deve obrigatoriamente implementar esta interface e ditar sua própria regra para o método de processamento.
 * </p>
 *
 * @author Nicolas
 */
public interface MetodoPagamento {
    /**
     * Processa o pagamento de um valor específico em Reais (BRL).
     *
     * @param valor O valor financeiro base a ser cobrado na transação.
     */
    void processarPagamento(double valor);

}
