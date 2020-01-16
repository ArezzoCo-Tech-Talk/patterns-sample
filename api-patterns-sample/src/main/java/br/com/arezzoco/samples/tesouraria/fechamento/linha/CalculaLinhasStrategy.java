package br.com.arezzoco.samples.tesouraria.fechamento.linha;

import br.com.arezzoco.samples.dto.PagamentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CalculaLinhasStrategy {

    @Autowired
    private List<CalculaLinha> linhas;

    //@Autowired
    //private CalculaLinhaTotalRecebido calculaLinhaTotalRecebido;

    public Map<String, BigDecimal> calcular(final List<PagamentoDTO> pagamentos) {
        //final List<CalculaLInha> linhas = new ArrayList<>();
        //linhas.add(calculaLinhaTotalRecebido);

        /* exemplo com map
        final Map<String, BigDecimal> linhasCalculadas = new HashMap<>();

        for (CalculaLInha linha : linhas) {
            linhasCalculadas.put(linha.getCodigo(), linha.calculaValorLinha(pagamentos));
        }

        return linhasCalculadas;*/

        // exemplo com stream
        return linhas.stream()
                .collect(Collectors.toMap(CalculaLinha::getCodigo, l -> l.calculaValorLinha(pagamentos)));
    }

}
