package br.com.arezzoco.samples.service;

import br.com.arezzoco.samples.dto.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CalculaTesourariaService {

    /*
    Recebe lista de pagamentos para serem calculados linhas de fim de turno.
    Valores serão enviados a um outro sistema.
     */
    public CalcularTesourariaResponse calcular(final CalcularTesourariaRequest request) {
        final CalcularTesourariaResponse response = new CalcularTesourariaResponse();

        BigDecimal linhaTotalRecebido = BigDecimal.ZERO;
        BigDecimal linhaTotalRecebidoBanrisul = BigDecimal.ZERO;
        BigDecimal linhaTotalRecebidoCarneJuros = BigDecimal.ZERO;
        BigDecimal linhaTotalRecebidoCarneProcessadoraB = BigDecimal.ZERO;
        BigDecimal linhaTotalRecebidoFaturaProcessadoraA = BigDecimal.ZERO;

        for (PagamentoDTO pagamento : request.getPagamentos()) {
            linhaTotalRecebido = linhaTotalRecebido.add(pagamento.getValorPago());

            if (pagamento.getAdquirente().equals("BANRISUL")) {
                linhaTotalRecebidoBanrisul = linhaTotalRecebidoBanrisul.add(pagamento.getValorPago());
            }

            for (CarneDTO carne : pagamento.getCarnes()) {
                if (carne.getValorJuros().compareTo(BigDecimal.ZERO) != 0) {
                    linhaTotalRecebidoCarneJuros = linhaTotalRecebidoCarneJuros.add(carne.getValorJuros());
                }

                if (carne.getProcessadora().equals("PROCESSADORA_B")) {
                    linhaTotalRecebidoCarneProcessadoraB = linhaTotalRecebidoCarneProcessadoraB.add(carne.getValorPago());
                }
            }

            for (FaturaDTO fatura : pagamento.getFaturas()) {
                if (fatura.getProcessadora().equals("PROCESSADORA_A")) {
                    linhaTotalRecebidoFaturaProcessadoraA = linhaTotalRecebidoFaturaProcessadoraA.add(fatura.getValorPago());
                }
            }
        }

        response.getLinhas().put("R38", linhaTotalRecebido);
        response.getLinhas().put("R62", linhaTotalRecebidoBanrisul);
        response.getLinhas().put("R49", linhaTotalRecebidoCarneProcessadoraB);
        response.getLinhas().put("R28", linhaTotalRecebidoFaturaProcessadoraA);
        response.getLinhas().put("R91", linhaTotalRecebidoCarneJuros);

        // TODO: envia para outro sistema

        return response;
    }

}
