package br.com.arezzoco.samples.service;

import br.com.arezzoco.samples.dto.*;
import br.com.arezzoco.samples.tesouraria.fechamento.linha.CalculaLinhasStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculaTesourariaV2Service {

    @Autowired
    private CalculaLinhasStrategy calculaLinhasStrategy;

    /*
    Recebe lista de pagamentos para serem calculados linhas de fim de turno.
    Valores serão enviados a um outro sistema.
     */
    public CalcularTesourariaResponse calcular(final CalcularTesourariaRequest request) {
        // FIXME: validator

        final CalcularTesourariaResponse response = new CalcularTesourariaResponse();

        response.getLinhas().putAll(calculaLinhasStrategy.calcular(request.getPagamentos()));

        // TODO: envia para outro sistema

        return response;
    }

}
