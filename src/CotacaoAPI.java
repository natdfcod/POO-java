import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * Classe responsável por integrar o sistema financeiro com serviços externos (APIs).
 * <p>
 * Realiza a comunicação HTTP para buscar dados e cotações do mercado de criptomoedas
 * em tempo real.
 * </p>
 *
 * @author Nicolas
 */
public class CotacaoAPI {

    /**
     * Conecta-se à API pública da Binance para obter a cotação atualizada do par BTC/BRL.
     * <p>
     * O método realiza uma requisição HTTP GET e extrai o valor do Bitcoin em Reais
     * a partir do corpo da resposta em JSON. Em caso de falha na rede, retorna um
     * valor de segurança predefinido para evitar a interrupção do sistema.
     * </p>
     *
     * @return A cotação atual de 1 Bitcoin convertido em Reais (BRL).
     */
    public double obterPrecoBitcoinEmReais() {
        try {
            // A URL pública da Binance para o par Bitcoin/Real
            String url = "https://api.binance.com/api/v3/ticker/price?symbol=BTCBRL";

            // Cria o "navegador" e o pedido
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

            // Envia o pedido e guarda a resposta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // O texto chega assim: {"symbol":"BTCBRL","price":"512345.67"}
            String json = response.body();

            // Truque rápido para extrair só o número do texto
            String precoLimpo = json.split("\"price\":\"")[1].replace("\"}", "");

            return Double.parseDouble(precoLimpo);

        } catch (Exception e) {
            System.out.println("Erro de conexão com a API. Usando cotação de segurança.");
            return 350000.0; // Se a internet cair, ele usa esse valor para não travar o programa
        }
    }
}